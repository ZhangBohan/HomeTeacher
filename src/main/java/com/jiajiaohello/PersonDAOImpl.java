package com.jiajiaohello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:56 PM
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Person p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }
}
