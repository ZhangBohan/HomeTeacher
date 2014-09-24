package com.jiajiaohello.core.lesson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/24/14
 * Time: 11:22 PM
 */
@Entity
public class Progress {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Lesson lesson;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", lesson=" + lesson +
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
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
