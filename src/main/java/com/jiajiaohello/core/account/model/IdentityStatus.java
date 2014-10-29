package com.jiajiaohello.core.account.model;

/**
 * User: bohan
 * Date: 10/29/14
 * Time: 2:25 PM
 */
public enum IdentityStatus {
    teacher(1), retirementTeacher(2), student(3);
    private Integer id;

    IdentityStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
