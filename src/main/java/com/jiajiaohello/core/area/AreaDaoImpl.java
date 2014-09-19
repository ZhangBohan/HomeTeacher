package com.jiajiaohello.core.area;

import com.jiajiaohello.core.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/19/14
 * Time: 11:22 AM
 */
@Repository
public class AreaDaoImpl implements AreaDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Area get(Integer id) {
        return hibernateTemplate.get(Area.class, id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Area entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public List<Area> getList(Area entity) {
        return hibernateTemplate.findByExample(entity);
    }

    @Override
    public List<Area> getList(Area entity, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(entity, firstResult, maxResult);
    }
}
