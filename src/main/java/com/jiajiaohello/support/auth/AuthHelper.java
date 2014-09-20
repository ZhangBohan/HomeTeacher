package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.UserAccount;
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

    public static UserAccount getUserAccount() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserAccount) principal);
        }
        return null;
    }

    public static TeacherAccount getTeacherAccount() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((TeacherAccount) principal);
        }
        return null;
    }

    public static ManagerAccount getManagerAccount() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((ManagerAccount) principal);
        }
        return null;
    }
}
