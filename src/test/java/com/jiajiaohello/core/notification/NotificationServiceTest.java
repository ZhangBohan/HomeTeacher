package com.jiajiaohello.core.notification;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class NotificationServiceTest extends BaseTest {
    @Autowired
    private NotificationService notificationService;

    @Test
    public void testGetAccountNotifications() throws Exception {
        List<AccountNotification> accountNotifications = notificationService.getAccountNotifications(3, NotificationStatus.unread);
        System.out.println(accountNotifications);
        assertNotNull(accountNotifications);
    }

    @Test
    public void testRead() throws Exception {
        notificationService.read(2);
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUserNotification() throws Exception {
        notificationService.userNotification(NotificationType.personal, "通知", "今天下午停水", 3, 3);
    }

    @Test
    public void testUserNotification1() throws Exception {

    }
}