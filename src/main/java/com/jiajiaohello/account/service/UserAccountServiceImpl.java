package com.jiajiaohello.account.service;

import com.jiajiaohello.account.dao.UserAccountDao;
import com.jiajiaohello.account.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountDao userAccountDao;

    private List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

    @Override
    @Transactional
    public User get(String username) {
        UserAccount account = new UserAccount(username);
        account = userAccountDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        userAccountDao.saveOrUpdate(account);
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
