package com.jiajiaohello.core.ticket;

import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/24/14
 * Time: 10:50 PM
 */
@Entity
public class ClassTicket implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private Course course;
    @ManyToOne
    private UserAccount userAccount;
    private Integer status = TicketStatus.open.getId();
    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "ClassTicket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", userAccount=" + userAccount +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
