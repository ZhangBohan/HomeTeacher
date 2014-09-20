package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.dao.TeacherAccountDao;
import com.jiajiaohello.core.account.model.TeacherAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Teacher: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class TeacherAccountServiceImpl implements TeacherAccountService {
    @Autowired
    private TeacherAccountDao userAccountDao;

    @Override
    @Transactional
    public TeacherAccount get(String username) {
        TeacherAccount account = new TeacherAccount(username);
        account = userAccountDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        userAccountDao.saveOrUpdate(account);
        return account;
    }
}
