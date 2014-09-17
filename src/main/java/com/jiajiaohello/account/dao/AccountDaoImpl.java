package com.jiajiaohello.account.dao;

import com.jiajiaohello.account.model.Account;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 2:38 PM
 */
public class AccountDaoImpl<K extends Account> implements AccountDao<K> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void saveOrUpdate(K account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    public K get(K account) {
        List<K> list = list(account, 0, 1);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<K> list(K account) {
        return hibernateTemplate.findByExample(account);
    }

    @Override
    public List<K> list(K account, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(account, firstResult, maxResult);
    }
}
