package com.jiajiaohello.core.notification;

/**
 * User: bohan
 * Date: 11/13/14
 * Time: 4:28 PM
 */
public enum NotificationStatus {
    unread(0), read(1), delete(-1);
    private Integer id;

    NotificationStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
