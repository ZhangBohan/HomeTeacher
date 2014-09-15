package com.jiajiaohello;

import java.util.List;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:55 PM
 */
public interface PersonDAO {
    Person find(Integer id);

    public void save(Person p);

    public List<Person> list();
}
