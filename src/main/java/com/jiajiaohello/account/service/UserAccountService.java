package com.jiajiaohello.account.service;

import org.springframework.security.core.userdetails.User;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface UserAccountService {
    static final String DEFAULT_ROLE = "ROLE_USER";

    User get(String username);
}
