package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.teacher.dto.EditForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface TeacherAccountService {
    TeacherAccount get(String username);

    void update(EditForm editForm) throws IOException;
}
