package com.jiajiaohello.support.auth;

import com.jiajiaohello.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 1:59 PM
 */
public class UserDetailService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountService.get(username);
    }
}
