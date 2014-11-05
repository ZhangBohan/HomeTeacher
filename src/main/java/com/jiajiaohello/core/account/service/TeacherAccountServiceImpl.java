package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.dao.TeacherAccountDao;
import com.jiajiaohello.core.account.model.IdentityStatus;
import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.auth.PasswordEncoder;
import com.jiajiaohello.support.auth.RegisterForm;
import com.jiajiaohello.support.auth.TeacherUserDetailService;
import com.jiajiaohello.support.core.OSSBucket;
import com.jiajiaohello.support.core.OSSService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private TeacherAccountDao teacherAccountDao;
    @Autowired
    private OSSService ossService;
    @Autowired
    private Jedis jedis;

    @Override
    @Transactional
    public TeacherAccount get(String username) {
        TeacherAccount account = new TeacherAccount(username);
        account = teacherAccountDao.get(account);
        if (account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        teacherAccountDao.saveOrUpdate(account);
        return account;
    }

    @Override
    public TeacherAccount get(Integer teacherId) {
        return teacherAccountDao.get(teacherId);
    }

    @Override
    public void update(EditForm editForm) throws IOException {
        TeacherAccount account = get(editForm.getUsername());
        if(account.getInfo() == null) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.init();
            account.setInfo(teacherInfo);
        }

        account.setName(editForm.getName());
        account.getInfo().setDescription(editForm.getDescription());
        account.getInfo().setSchool(editForm.getSchool());
        account.getInfo().setFreeTime(editForm.getFreeTime());
        account.getInfo().setIdentity(editForm.getIdentity());

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
        teacherAccountDao.saveOrUpdate(account);
    }

    @Override
    public void create(RegisterForm registerForm) {
        TeacherAccount teacherAccount = new TeacherAccount();
        try {
            BeanUtils.copyProperties(teacherAccount, registerForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        teacherAccount.setUsername(registerForm.getPhone());
        teacherAccount.setPassword(new PasswordEncoder().encode(registerForm.getPassword()));   // 加密后保存
        teacherAccountDao.saveOrUpdate(teacherAccount);
    }

    @Override
    public void updateCourses(Integer[] courseIds) {
        TeacherAccount teacherAccount = teacherAccountDao.get(new TeacherAccount(AuthHelper.getUsername()));
        List<Course> courses = new ArrayList<>();
        for (Integer courseId : courseIds) {
            Course course = new Course();
            course.setId(courseId);
            courses.add(course);
        }
        teacherAccount.getInfo().setCourses(courses);

        teacherAccountDao.saveOrUpdate(teacherAccount);
    }

    @Override
    public List<TeacherAccount> getRecommendTeacherAccounts(RecommendType recommendType, Integer start, Integer size) {
        List<String> teacherIdStrings = jedis.lrange("recommend:teachers:" + recommendType, start, size);
        List<TeacherAccount> list = new ArrayList<>();
        for (String teacherIdString : teacherIdStrings) {
            TeacherAccount teacherAccount = teacherAccountDao.get(Integer.parseInt(teacherIdString));
            list.add(teacherAccount);
        }


        return list;
    }
}
