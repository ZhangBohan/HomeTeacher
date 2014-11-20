package com.jiajiaohello.core.ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: bohan
 * Date: 11/17/14
 * Time: 5:23 PM
 */
public class ClassTicketForm {
    private String address;
    private String teachingAt;
    private Integer course;
    private Integer teacherId;

    @Override
    public String toString() {
        return "ClassTicketForm{" +
                "address='" + address + '\'' +
                ", teachingAt='" + teachingAt + '\'' +
                ", course=" + course +
                ", teacherId=" + teacherId +
                '}';
    }

    public Date getTeachingDate() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(teachingAt);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeachingAt() {
        return teachingAt;
    }

    public void setTeachingAt(String teachingAt) {
        this.teachingAt = teachingAt;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
