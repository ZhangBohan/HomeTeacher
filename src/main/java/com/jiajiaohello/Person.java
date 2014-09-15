package com.jiajiaohello;

import javax.persistence.*;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:54 PM
 */
@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String country;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}