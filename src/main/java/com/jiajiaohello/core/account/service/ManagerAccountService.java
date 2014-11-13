package com.jiajiaohello.core.account.service;

import java.io.IOException;

import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.admin.dto.EditForm;
import com.jiajiaohello.support.auth.RegisterForm;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface ManagerAccountService {
    ManagerAccount get(String username);
    void create(RegisterForm registerForm);
    void update(EditForm editForm) throws IOException;
}
