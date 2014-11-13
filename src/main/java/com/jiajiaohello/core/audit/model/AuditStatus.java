package com.jiajiaohello.core.audit.model;

/**
 * 审核状态
 *
 * User: bohan
 * Date: 11/8/14
 * Time: 3:46 PM
 */
public enum AuditStatus {
    open(0),    // 打开状态，默认为打开
    pass(1),    // 通过状态
    reject(-1), // 拒绝状态
    close(-2);  // 关闭状态

    AuditStatus(Integer id) {
        this.id = id;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
