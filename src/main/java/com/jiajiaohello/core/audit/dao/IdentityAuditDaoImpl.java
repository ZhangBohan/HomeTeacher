package com.jiajiaohello.core.audit.dao;

import com.jiajiaohello.core.audit.model.IdentityAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: bohan
 * Date: 11/8/14
 * Time: 3:35 PM
 */
@Repository
public class IdentityAuditDaoImpl implements IdentityAuditDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public IdentityAudit get(Integer id) {
        return hibernateTemplate.get(IdentityAudit.class, id);
    }

    @Override
    public void saveOrUpdate(IdentityAudit entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public List<IdentityAudit> getList(IdentityAudit entity) {
        return hibernateTemplate.findByExample(entity);
    }

    @Override
    public List<IdentityAudit> getList(IdentityAudit entity, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(entity);
    }
}
