package com.jiajiaohello.core.account.dao;

import com.jiajiaohello.core.account.model.UserAccount;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 3:01 PM
 */
@Repository
public class UserAccountDaoImpl implements UserAccountDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void saveOrUpdate(UserAccount account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    public UserAccount get(UserAccount account) {
        List<UserAccount> list = list(account, 0, 1);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<UserAccount> list(UserAccount account) {
        return hibernateTemplate.findByExample(account);
    }

    @Override
    public List<UserAccount> list(UserAccount account, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(account, firstResult, maxResult);
    }
}
