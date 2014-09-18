package com.jiajiaohello.notification;

import com.jiajiaohello.account.model.Account;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.*;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/18/14
 * Time: 4:26 PM
 */
@Entity
public class Notification {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Account account;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    private Boolean hasRead;

    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
        this.hasRead = false;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", account=" + account +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", hasRead=" + hasRead +
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasRead() {
        return hasRead;
    }

    public void setHasRead(Boolean hasRead) {
        this.hasRead = hasRead;
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
