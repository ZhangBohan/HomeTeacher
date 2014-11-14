package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.Account;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 6:25 PM
 */
public interface AccountService {
    Account get(String username);
}
