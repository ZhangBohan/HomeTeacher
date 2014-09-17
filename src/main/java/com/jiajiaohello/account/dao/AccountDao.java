package com.jiajiaohello.account.dao;

import com.jiajiaohello.account.model.Account;

import java.util.List;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 3:05 PM
 */
public interface AccountDao<T extends Account> {
    void saveOrUpdate(T account);

    T get(T account);

    List<T> list(T account);

    List<T> list(T account, int firstResult, int maxResult);
}
