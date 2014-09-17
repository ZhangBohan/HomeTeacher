package com.jiajiaohello.account.service;

import org.springframework.security.core.userdetails.User;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface TeacherAccountService {
    static final String DEFAULT_ROLE = "ROLE_TEACHER";

    User get(String username);
}
