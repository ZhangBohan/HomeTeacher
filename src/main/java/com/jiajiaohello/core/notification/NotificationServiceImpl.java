package com.jiajiaohello.core.notification;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.support.core.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 11:26 AM
 */
@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private CommonDao<AccountNotification> accountNotificationCommonDao;
    @Autowired
    private CommonDao<Notification> notificationCommonDao;

    @Override
    public List<AccountNotification> getAccountNotifications(Integer accountId) {
        AccountNotification accountNotification = new AccountNotification();
        accountNotification.setAccount(new Account(accountId));
        return accountNotificationCommonDao.getList(accountNotification);
    }

    @Override
    public List<AccountNotification> getAccountNotifications(Integer accountId, NotificationStatus status) {
        AccountNotification accountNotification = new AccountNotification();
        accountNotification.setAccount(new Account(accountId));
        accountNotification.setStatus(status.getId());
        return accountNotificationCommonDao.getList(accountNotification);
    }

    @Override
    public void read(Integer id) {
        AccountNotification accountNotification = accountNotificationCommonDao.get(id, AccountNotification.class);
        accountNotification.setStatus(NotificationStatus.read.getId());
        accountNotificationCommonDao.saveOrUpdate(accountNotification);
    }

    @Override
    public void delete(Integer id) {
        AccountNotification accountNotification = accountNotificationCommonDao.get(id, AccountNotification.class);
        accountNotification.setStatus(NotificationStatus.delete.getId());
        accountNotificationCommonDao.saveOrUpdate(accountNotification);
    }

    @Override
    public void userNotification(NotificationType type, String title, String description, Integer senderId, Integer targetId) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setDescription(description);
        notification.setSender(new Account(senderId));
        notification.setType(type.getId());
        notificationCommonDao.saveOrUpdate(notification);

        AccountNotification accountNotification = new AccountNotification();
        accountNotification.init();
        accountNotification.setAccount(new Account(targetId));
        accountNotification.setNotification(notification);
        accountNotificationCommonDao.saveOrUpdate(accountNotification);
    }

    @Override
    public void userNotification(NotificationType type, String title, String description, Integer senderId, List<Integer> targetIds) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setDescription(description);
        notification.setType(type.getId());
        notification.setSender(new Account(senderId));
        notificationCommonDao.saveOrUpdate(notification);

        AccountNotification accountNotification = new AccountNotification();
        accountNotification.init();
        for (Integer targetId : targetIds) {
            accountNotification.setAccount(new Account(targetId));
            accountNotification.setNotification(notification);
            accountNotificationCommonDao.saveOrUpdate(accountNotification);
        }
    }
}