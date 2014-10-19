package com.jiajiaohello.core.teacher;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.exception.TeacherInfoNotFillException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * User: bohan
 * Date: 10/8/14
 * Time: 10:43 PM
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping
    @ResponseBody
    public TeacherAccount index() throws TeacherInfoNotFillException {
        verify();
        return AuthHelper.getTeacherAccount();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(Model model) {
        TeacherAccount teacherAccount = AuthHelper.getTeacherAccount();
        model.addAttribute("teacherAccount", teacherAccount);
        return "teacher/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(TeacherAccount teacherAccount, MultipartFile avatarFile) {

        return "redirect:/teacher/edit";
    }

    public void verify() throws TeacherInfoNotFillException {
        TeacherAccount teacherAccount = AuthHelper.getTeacherAccount();
        TeacherInfo info = teacherAccount.getInfo();
        if(info == null || !info.getCompleted()) {
            throw new TeacherInfoNotFillException();
        }
    }
}
