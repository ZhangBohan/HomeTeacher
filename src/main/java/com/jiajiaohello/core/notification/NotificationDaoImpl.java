package com.jiajiaohello.core.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/18/14
 * Time: 4:39 PM
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Notification get(Integer id) {
        return hibernateTemplate.get(Notification.class, id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Notification notification) {
        hibernateTemplate.saveOrUpdate(notification);
    }

    @Override
    public List<Notification> getList(Notification entity) {
        return hibernateTemplate.findByExample(entity);
    }

    @Override
    public List<Notification> getList(Notification entity, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(entity, firstResult, maxResult);
    }
}
