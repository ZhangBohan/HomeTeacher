package com.jiajiaohello.core.account.model;

/**
 * User: bohan
 * Date: 10/29/14
 * Time: 2:25 PM
 */
public enum IdentityStatus {
    inServiceTeacher(1, "在职教员"), fullTimeTeacher(2, "专职教员"), collegeTeacher(3, "大学生教员");
    private Integer id;
    private String name;

    IdentityStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
