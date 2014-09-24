package com.jiajiaohello.core.lesson;

import com.jiajiaohello.core.ticket.ClassTicket;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/24/14
 * Time: 11:17 PM
 */
@Entity
public class Lesson {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private ClassTicket classTicket;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", classTicket=" + classTicket +
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

    public ClassTicket getClassTicket() {
        return classTicket;
    }

    public void setClassTicket(ClassTicket classTicket) {
        this.classTicket = classTicket;
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
