package com.jiajiaohello.core.audit.model;

import com.jiajiaohello.core.account.model.TeacherAccount;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * User: bohan
 * Date: 11/8/14
 * Time: 3:31 PM
 */
@Entity
public class IdentityAudit extends Audit {
    @ManyToOne
    private TeacherAccount teacher;

    @Override
    public String toString() {
        return "IdentityAudit{" +
                "id=" + getId() +
                "\nstatus=" + getStatus() +
                "\nteacher=" + teacher +
                '}';
    }

    public TeacherAccount getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherAccount teacher) {
        this.teacher = teacher;
    }
}
