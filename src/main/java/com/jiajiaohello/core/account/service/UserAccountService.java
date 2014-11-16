package com.jiajiaohello.core.account.service;

import java.util.List;

import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.support.auth.RegisterForm;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface UserAccountService {
    UserAccount get(String username);

    void create(RegisterForm form);
    
    public List<UserAccount> getUserAccounts(UserAccount entity,Integer firstResult, Integer maxResult);
    
    public int getCount() ;
}
