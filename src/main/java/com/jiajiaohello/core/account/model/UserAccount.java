package com.jiajiaohello.core.account.model;

import javax.persistence.Entity;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 5:33 PM
 */
@Entity
public class UserAccount extends Account {
    public UserAccount() {
    }

    public UserAccount(String username) {
        super(username);
    }
}
