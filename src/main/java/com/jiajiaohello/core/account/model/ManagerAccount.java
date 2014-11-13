package com.jiajiaohello.core.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 5:34 PM
 */
@Entity
public class ManagerAccount extends Account {
	private static final long serialVersionUID = -6301850334377748839L;
	static final String DEFAULT_ROLE = "ROLE_ADMIN";
    static List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

    public ManagerAccount() {
    }

    public ManagerAccount(String username) {
        super(username);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
