package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.model.Account;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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

    public static void reloadAccount(Account account) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(account, account.getPassword(), account.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
