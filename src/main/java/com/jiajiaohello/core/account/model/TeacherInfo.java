package com.jiajiaohello.core.account.model;

import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bohan
 * Date: 10/8/14
 * Time: 10:31 PM
 */
@Entity
public class TeacherInfo implements Serializable{

    private static final long serialVersionUID = -1611185333855335859L;

    @Id
    @GeneratedValue
    private Integer id;
    private Boolean completed;
    private Boolean audited;

    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.completed = Boolean.FALSE;
        this.audited = Boolean.FALSE;
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getAudited() {
        return audited;
    }

    public void setAudited(Boolean audited) {
        this.audited = audited;
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
