package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.ManagerAccount;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface ManagerAccountService {
    ManagerAccount get(String username);
}
