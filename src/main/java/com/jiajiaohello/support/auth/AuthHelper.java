package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.model.Account;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User: bohan
 * Date: 9/21/14
 * Time: 1:30 AM
 */
public class AuthHelper {

    private static Object getPrincipal() {
        return SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }

    public static String getUsername() {
        return getUserDetails().getUsername();
    }

    public static UserDetails getUserDetails() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal);
        }
        return null;
    }

    public static Account getAccount() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((Account) principal);
        }
        return null;
    }

    public static AuthUser getUserAccount() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((AuthUser) principal);
        }
        return null;
    }

    public static void reloadAccount(Account account, List<SimpleGrantedAuthority> authorities) {
        AuthUser user = new AuthUser();
        try {
            BeanUtils.copyProperties(user, account);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, account.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
