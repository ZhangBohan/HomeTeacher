package com.jiajiaohello.core.info.dao;

import com.jiajiaohello.core.info.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: bohan
 * Date: 11/4/14
 * Time: 10:54 PM
 */
@Repository
public class StageDaoImpl implements StageDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Stage get(Integer id) {
        return hibernateTemplate.get(Stage.class, id);
    }

    @Override
    public void saveOrUpdate(Stage entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public List<Stage> getList(Stage entity) {
        return hibernateTemplate.findByExample(entity);
    }

    @Override
    public List<Stage> getList(Stage entity, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(entity, firstResult, maxResult);
    }
}
