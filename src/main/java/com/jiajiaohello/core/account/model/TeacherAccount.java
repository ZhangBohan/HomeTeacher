package com.jiajiaohello.core.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 5:34 PM
 */
@Entity
public class TeacherAccount extends Account {
    private static final long serialVersionUID = -1112204397272052960L;

    static final String DEFAULT_ROLE = "ROLE_TEACHER";

    @OneToOne
    private TeacherInfo info;

    static List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

    public TeacherAccount() {
    }

    public TeacherAccount(String username) {
        super(username);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public TeacherInfo getInfo() {
        return info;
    }

    public void setInfo(TeacherInfo info) {
        this.info = info;
    }
}
