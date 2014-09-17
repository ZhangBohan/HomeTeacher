package com.jiajiaohello.support.auth;

import com.jiajiaohello.account.service.TeacherAccountService;
import com.jiajiaohello.account.service.UserAccountService;
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
@Service("teacherUserDetailsService")
public class TeacherUserDetailService implements UserDetailsService {
    @Autowired
    private TeacherAccountService teacherAccountService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return teacherAccountService.get(username);
    }
}
