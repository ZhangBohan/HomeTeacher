package com.jiajiaohello.core.account.dao;

import com.jiajiaohello.core.account.model.TeacherAccount;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Teacher: bohan
 * Date: 9/17/14
 * Time: 3:01 PM
 */
@Repository
public class TeacherAccountDaoImpl implements TeacherAccountDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void saveOrUpdate(TeacherAccount account) {
        hibernateTemplate.saveOrUpdate(account.getInfo());
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    public TeacherAccount get(TeacherAccount account) {
        List<TeacherAccount> list = list(account, 0, 1);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public TeacherAccount get(Integer id) {
        return hibernateTemplate.get(TeacherAccount.class, id);
    }

    @Override
    public List<TeacherAccount> list(TeacherAccount account) {
        return hibernateTemplate.findByExample(account);
    }

    @Override
    public List<TeacherAccount> list(TeacherAccount account, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(account, firstResult, maxResult);
    }
}
