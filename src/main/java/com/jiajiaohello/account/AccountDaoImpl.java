package com.jiajiaohello.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 3:07 PM
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void save(Account account) {
        hibernateTemplate.save(account);
    }

    @Override
    public List<Account> list() {
        return (List<Account>) hibernateTemplate.find("from Account");
    }
}
