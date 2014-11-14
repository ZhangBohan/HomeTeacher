package com.jiajiaohello.core.notification;

import java.util.List;

/**
 * User: bohan
 * Date: 9/18/14
 * Time: 5:41 PM
 */
public interface NotificationService {
    /**
     * 取得全部通知
     *
     * @param accountId 用户ID
     * @return 通知列表
     */
    List<AccountNotification> getAccountNotifications(Integer accountId);

    /**
     * 取得某状态的通知
     * @param accountId 用户ID
     * @param status 通知状态
     * @return 通知列表
     */
    List<AccountNotification> getAccountNotifications(Integer accountId, NotificationStatus status);

    void read(Integer id);

    void delete(Integer id);

    /**
     * 用户发送通知
     *
     * @param title 标题
     * @param description 正文
     * @param senderId 发送者
     * @param targetId 目标用户
     */
    void userNotification(NotificationType type, String title, String description, Integer senderId, Integer targetId);

    /**
     * 用户发送通知
     *
     * @param title 标题
     * @param description 正文
     * @param senderId 发送者
     * @param targetIds 目标用户列表
     */
    void userNotification(NotificationType type, String title, String description, Integer senderId, List<Integer> targetIds);
}
