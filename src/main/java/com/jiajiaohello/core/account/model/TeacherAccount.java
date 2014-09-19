package com.jiajiaohello.core.account.model;

import javax.persistence.Entity;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 5:34 PM
 */
@Entity
public class TeacherAccount extends Account {
    public TeacherAccount() {
    }

    public TeacherAccount(String username) {
        super(username);
    }
}
