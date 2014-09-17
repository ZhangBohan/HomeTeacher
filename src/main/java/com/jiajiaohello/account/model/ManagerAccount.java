package com.jiajiaohello.account.model;

import javax.persistence.Entity;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 5:34 PM
 */
@Entity
public class ManagerAccount extends Account {
    public ManagerAccount() {
    }

    public ManagerAccount(String username) {
        super(username);
    }
}
