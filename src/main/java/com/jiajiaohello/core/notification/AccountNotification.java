package com.jiajiaohello.core.notification;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 10:38 AM
 */
@Entity
public class AccountNotification {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Notification notification;
    @ManyToOne
    private Account account;
    private Integer status;

    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.status = NotificationStatus.unread.getId();
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "AccountNotification{" +
                "id=" + id +
                ", notification=" + notification +
                ", account=" + account +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
