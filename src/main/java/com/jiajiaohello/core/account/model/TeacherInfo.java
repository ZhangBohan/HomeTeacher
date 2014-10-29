package com.jiajiaohello.core.account.model;

import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.support.core.CommonHelper;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private Integer identity = IdentityStatus.student.getId();
    private String school;
    private String description;
    private String freeTime;
    @ManyToMany
    @OrderColumn
    List<Course> courses;

    private String identityUrl;
    private String educationUrl;

    private Boolean completed;
    private Boolean audited;

    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.completed = Boolean.TRUE;
        this.audited = Boolean.FALSE;
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "id=" + id +
                ", identity=" + identity +
                ", school='" + school + '\'' +
                ", description='" + description + '\'' +
                ", freeTime='" + freeTime + '\'' +
                ", courses=" + courses +
                ", identityUrl='" + identityUrl + '\'' +
                ", educationUrl='" + educationUrl + '\'' +
                ", completed=" + completed +
                ", audited=" + audited +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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

    public String getIdentityUrl() {
        return identityUrl;
    }

    public void setIdentityUrl(String identityUrl) {
        this.identityUrl = identityUrl;
    }

    public String getEducationUrl() {
        return educationUrl;
    }

    public void setEducationUrl(String educationUrl) {
        this.educationUrl = educationUrl;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
}
