package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.account.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 1:59 PM
 */
@Service("userUserDetailsService")
public class UserUserDetailService implements UserDetailsService {
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserAccount loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService.get(username);
    }
    
}
