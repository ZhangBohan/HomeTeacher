package com.jiajiaohello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:56 PM
 */
@Repository
public class PersonDAOImpl implements PersonDAO {


    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Person find(Integer id) {
        return hibernateTemplate.get(Person.class, id);
    }

    @Override
    @Transactional
    public void save(Person p) {
        hibernateTemplate.saveOrUpdate(p);
    }

    @Override
    public List<Person> list() {
        return (List<Person>) hibernateTemplate.find("from Person");
    }
}
