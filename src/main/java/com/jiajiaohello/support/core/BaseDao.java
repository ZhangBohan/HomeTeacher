package com.jiajiaohello.support.core;

import com.jiajiaohello.notification.Notification;

import java.util.List;

/**
 * User: bohan
 * Date: 9/18/14
 * Time: 5:42 PM
 */
public interface BaseDao<T> {
    T get(Integer id);

    void saveOrUpdate(Notification notification);

    List<T> getList(T entity);

    List<Notification> getList(T entity, int firstResult, int maxResult);
}
