package com.jiajiaohello.core.ticket;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.info.model.Course;
import com.jiajiaohello.support.core.CommonHelper;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String name;
    private String phone;
    private String address;

    private String description;
    @ManyToOne
    private Course course = new Course();
    @ManyToOne
    private UserAccount userAccount;
    @ManyToOne
    private TeacherAccount teacherAccount;
    private Integer status;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<ClassTicketNote> notes;
    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.status = TicketStatus.open.getId();
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "ClassTicket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", userAccount=" + userAccount +
                ", teacherAccount=" + teacherAccount +
                ", status=" + status +
                ", notes=" + notes +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public TeacherAccount getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(TeacherAccount teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ClassTicketNote> getNotes() {
        return notes;
    }

    public void setNotes(List<ClassTicketNote> notes) {
        this.notes = notes;
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
