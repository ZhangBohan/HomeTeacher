package com.jiajiaohello.core.notification;

/**
 * User: bohan
 * Date: 11/13/14
 * Time: 4:27 PM
 */
public enum NotificationType {
    personal(0), system(1);
    private Integer id;

    NotificationType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
