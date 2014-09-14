package com.jiajiaohello;

import javax.persistence.*;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:54 PM
 */
@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country;
    }
}