package com.jiajiaohello.core.info.dao;

import com.jiajiaohello.core.info.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: bohan
 * Date: 10/29/14
 * Time: 11:30 AM
 */
@Repository
public class CourseDaoImpl implements CourseDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Course get(Integer id) {
        return hibernateTemplate.get(Course.class, id);
    }

    @Override
    public void saveOrUpdate(Course entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public List<Course> getList(Course entity) {
        return hibernateTemplate.findByExample(entity);
    }

    @Override
    public List<Course> getList(Course entity, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(entity, firstResult, maxResult);
    }
}
