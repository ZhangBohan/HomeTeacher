package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.dao.TeacherAccountDao;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.core.OSSBucket;
import com.jiajiaohello.support.core.OSSService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

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

        String avatar = ossService.upload(editForm.getAvatarFile(), OSSBucket.avatar, Integer.toString(account.getId()));
        if(StringUtils.isNotBlank(avatar)) {
            account.setAvatar(avatar);
        }

        teacherAccountDao.saveOrUpdate(account);
    }
}
