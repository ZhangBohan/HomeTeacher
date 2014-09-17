package com.jiajiaohello.account.service;

import com.jiajiaohello.account.dao.TeacherAccountDao;
import com.jiajiaohello.account.model.TeacherAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
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
    private TeacherAccountDao userAccountDao;

    private List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

    @Override
    @Transactional
    public User get(String username) {
        TeacherAccount account = new TeacherAccount(username);
        account = userAccountDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        userAccountDao.saveOrUpdate(account);
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
