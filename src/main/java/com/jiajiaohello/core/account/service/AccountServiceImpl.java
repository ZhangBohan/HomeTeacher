package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.support.core.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 6:25 PM
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private CommonDao<Account> accountCommonDao;

    @Override
    public Account get(String username) {
        return accountCommonDao.get(new Account(username));
    }
}
