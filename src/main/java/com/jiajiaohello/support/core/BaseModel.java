package com.jiajiaohello.support.core;

import javax.persistence.*;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/18/14
 * Time: 4:34 PM
 */
public class BaseModel {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
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
