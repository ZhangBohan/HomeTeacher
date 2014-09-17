package com.jiajiaohello.account.service;

import org.springframework.security.core.userdetails.User;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface ManagerAccountService {
    static final String DEFAULT_ROLE = "ROLE_ADMIN";

    User get(String username);
}
