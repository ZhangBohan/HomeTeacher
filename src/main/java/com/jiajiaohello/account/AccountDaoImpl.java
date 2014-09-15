package com.jiajiaohello.account;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.mapping.Collection;
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
    public void saveOrUpdate(Account account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    public List<Account> list() {
        return (List<Account>) hibernateTemplate.find("from Account");
    }

    @Override
    public Account get(String username) {
        List<Account> list = (List<Account>) hibernateTemplate.find("from Account WHERE username=?", username);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}
