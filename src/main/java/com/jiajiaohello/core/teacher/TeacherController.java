package com.jiajiaohello.core.teacher;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.exception.TeacherInfoNotFillException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: bohan
 * Date: 10/8/14
 * Time: 10:43 PM
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @RequestMapping("/index")
    @ResponseBody
    public TeacherAccount index() throws TeacherInfoNotFillException {
        verify();
        return AuthHelper.getTeacherAccount();
    }

    public void verify() throws TeacherInfoNotFillException {
        TeacherAccount teacherAccount = AuthHelper.getTeacherAccount();
        TeacherInfo info = teacherAccount.getInfo();
        if(info == null || !info.getCompleted()) {
            throw new TeacherInfoNotFillException();
        }
    }
}
