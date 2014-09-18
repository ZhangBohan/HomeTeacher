package com.jiajiaohello.notification;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.account.dao.UserAccountDao;
import com.jiajiaohello.account.model.Account;
import com.jiajiaohello.account.model.UserAccount;
import com.jiajiaohello.account.service.UserAccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.util.List;

import static org.junit.Assert.*;

public class NotificationDaoTest extends BaseTest {
    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Test
    public void testSaveOrUpdate() throws Exception {
        UserAccount userAccount = userAccountDao.get(new UserAccount("bohan"));

        Notification notification = new Notification();
        notification.init();
        notification.setTitle("test");
        notification.setDescription("this is an test notification");
        notification.setAccount(userAccount);
        notification.setHasRead(true);
        notificationDao.saveOrUpdate(notification);
    }

    @Test
    public void testGetNotifications() {
        Notification notification = new Notification();
        notification.setHasRead(true);
        notification.setAccount(new Account("bohan"));
        List<Notification> notifications = notificationDao.getList(notification);
        System.out.println(notifications);
        assertNotNull(notifications);
    }
}