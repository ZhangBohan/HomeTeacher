package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.service.ManagerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 1:59 PM
 */
@Service("managerUserDetailsService")
public class ManagerUserDetailService implements UserDetailsService {
    @Autowired
    private ManagerAccountService managerAccountService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerAccountService.get(username);
    }
}
