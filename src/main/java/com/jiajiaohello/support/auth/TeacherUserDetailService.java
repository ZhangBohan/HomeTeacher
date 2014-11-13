package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 1:59 PM
 */
@Service("teacherUserDetailsService")
public class TeacherUserDetailService implements UserDetailsService {
    @Autowired
    private TeacherAccountService teacherAccountService;

    static final String DEFAULT_ROLE = "ROLE_TEACHER";
    public static List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
        TeacherAccount teacherAccount = teacherAccountService.loginLoad(username);
        if(teacherAccount == null) {
            throw new UsernameNotFoundException("未找到该用户！");
        }
        AuthUser user = new AuthUser();
        try {
            BeanUtils.copyProperties(user, teacherAccount);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        user.setAuthorities(authorities);
        return user;
    }
}
