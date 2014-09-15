package com.jiajiaohello.account;

import java.util.List;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 3:05 PM
 */
public interface AccountDao {
    void saveOrUpdate(Account account);

    List<Account> list();

    Account get(String username);
}
