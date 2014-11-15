package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.auth.PasswordEncoder;
import com.jiajiaohello.support.auth.RegisterForm;
import com.jiajiaohello.support.auth.TeacherUserDetailService;
import com.jiajiaohello.support.core.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Teacher: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class TeacherAccountServiceImpl implements TeacherAccountService {
    @Autowired
    private CommonDao<TeacherAccount> teacherAccountCommonDao;
    @Autowired
    private OSSService ossService;
    @Autowired
    private Jedis jedis;

    @Override
    public TeacherAccount get(String username) {
        return teacherAccountCommonDao.get(new TeacherAccount(username));
    }

    @Override
    @Transactional
    public TeacherAccount loginLoad(String username) {
        TeacherAccount account = new TeacherAccount(username);
        account = teacherAccountCommonDao.get(account);
        if (account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        teacherAccountCommonDao.saveOrUpdate(account);
        return account;
    }

    @Override
    public TeacherAccount get(Integer teacherId) {
        return teacherAccountCommonDao.get(teacherId, TeacherAccount.class);
    }

    @Override
    public void update(EditForm editForm) throws IOException {
        TeacherAccount account = get(editForm.getUsername());

        account.setName(editForm.getName());
        account.getInfo().setCompleted(Boolean.TRUE);
        account.getInfo().setDescription(editForm.getDescription());
        account.getInfo().setSchool(editForm.getSchool());
        account.getInfo().setFreeTime(editForm.getFreeTime());
        account.getInfo().setIdentity(editForm.getIdentity());
        account.getInfo().setSex(editForm.getSex());

        String avatar = ossService.upload(editForm.getAvatarFile(), OSSBucket.avatar, Integer.toString(account.getId()));
        if(StringUtils.isNotBlank(avatar)) {
            account.setAvatar(avatar);
        }
        String identityUrl = ossService.upload(editForm.getIdentityFile(), OSSBucket.avatar, "identity_" + account.getId());
        if(StringUtils.isNotBlank(identityUrl)) {
            account.getInfo().setIdentityUrl(identityUrl);
        }
        String educationUrl = ossService.upload(editForm.getEducationFile(), OSSBucket.avatar, "education_" + account.getId());
        if(StringUtils.isNotBlank(educationUrl)) {
            account.getInfo().setEducationUrl(educationUrl);
        }
        AuthHelper.reloadAccount(account, TeacherUserDetailService.authorities);
        teacherAccountCommonDao.saveOrUpdate(account);
    }

    @Override
    public void create(RegisterForm registerForm) {
        TeacherAccount teacherAccount = new TeacherAccount();
        try {
            BeanUtils.copyProperties(teacherAccount, registerForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        teacherAccount.setAvatar(CommonHelper.DEFAULT_AVATAR_URL);
        teacherAccount.setUsername(registerForm.getPhone());
        teacherAccount.setPassword(new PasswordEncoder().encode(registerForm.getPassword()));   // 加密后保存
        TeacherInfo info = new TeacherInfo();
        info.init();
        teacherAccount.setInfo(info);
        teacherAccountCommonDao.saveOrUpdate(teacherAccount);
    }

    @Override
    public void updateCourses(Integer[] courseIds) {
        TeacherAccount teacherAccount = teacherAccountCommonDao.get(new TeacherAccount(AuthHelper.getUsername()));
        List<Course> courses = new ArrayList<>();
        for (Integer courseId : courseIds) {
            Course course = new Course();
            course.setId(courseId);
            courses.add(course);
        }
        teacherAccount.getInfo().setCourses(courses);

        teacherAccountCommonDao.saveOrUpdate(teacherAccount);
    }

    @Override
    public List<TeacherAccount> getRecommendTeacherAccounts(RecommendType recommendType, Integer start, Integer size) {
        int end = start + size - 1;
        List<String> teacherIdStrings = jedis.lrange(RedisKeys.recommendTeachers.getKey(recommendType), start, end);
        List<TeacherAccount> list = new ArrayList<>();
        for (String teacherIdString : teacherIdStrings) {
            TeacherAccount teacherAccount = teacherAccountCommonDao.get(Integer.parseInt(teacherIdString), TeacherAccount.class);
            if(teacherAccount != null) {  // 如果取到数据，则加入
                list.add(teacherAccount);
            }
        }

        return list;
    }
}
