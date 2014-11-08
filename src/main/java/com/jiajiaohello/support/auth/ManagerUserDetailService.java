package com.jiajiaohello.support.auth;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.account.service.ManagerAccountService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: bohan
 * Date: 9/15/14
 * Time: 1:59 PM
 */
@Service("managerUserDetailsService")
public class ManagerUserDetailService implements UserDetailsService {
	@Autowired
	private ManagerAccountService managerAccountService;
	static final String DEFAULT_ROLE = "ROLE_ADMIN";
	public static List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(DEFAULT_ROLE));

	@Override
	public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
		ManagerAccount manangerAccount = managerAccountService.get(username);
		AuthUser user = new AuthUser();
		try {
			BeanUtils.copyProperties(user, manangerAccount);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setAuthorities(authorities);
		return user;
	}
}
