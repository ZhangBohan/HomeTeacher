package com.jiajiaohello.account;

import com.jiajiaohello.support.auth.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 5:20 PM
 */
@Service
public class AccountServiceImpl implements AccountService {
    public static final String DEFAULT_ROLE = "ROLE_USER";

    @Autowired private AccountDao accountDao;
    private List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));


    @Override
    public User get(String username) {
        Account account = accountDao.get(username);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        accountDao.saveOrUpdate(account);
        return new User(account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public void save(Account account) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassWord = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassWord);
        accountDao.saveOrUpdate(account);
    }
}
