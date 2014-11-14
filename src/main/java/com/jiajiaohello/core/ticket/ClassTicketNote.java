package com.jiajiaohello.core.ticket;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/24/14
 * Time: 10:50 PM
 */
@Entity
public class ClassTicketNote implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Account account;
    private Integer status;
    private String note;
    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "ClassTicketNote{" +
                "id=" + id +
                ", account=" + account +
                ", status=" + status +
                ", note='" + note + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
