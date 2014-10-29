package com.jiajiaohello.core.teacher;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.exception.TeacherInfoNotFillException;
import com.jiajiaohello.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * User: bohan
 * Date: 10/8/14
 * Time: 10:43 PM
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherAccountService teacherAccountService;

    @RequestMapping
    @ResponseBody
    public TeacherAccount index() throws TeacherInfoNotFillException {
        verify();
        return teacherAccountService.get(AuthHelper.getUserAccount().getUsername());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(Model model) {
        TeacherAccount teacherAccount = teacherAccountService.get(AuthHelper.getUserAccount().getUsername());
        model.addAttribute("teacherAccount", teacherAccount);
        return "teacher/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@Valid EditForm editForm, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if(result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(redirectAttributes, objectError.getDefaultMessage());
            }
        } else {
            teacherAccountService.update(editForm);
            MessageHelper.addSuccessAttribute(redirectAttributes, "更新成功！");
        }
        return "redirect:/teacher/edit";
    }

    public void verify() throws TeacherInfoNotFillException {
        TeacherAccount teacherAccount = teacherAccountService.get(AuthHelper.getUserAccount().getUsername());
        TeacherInfo info = teacherAccount.getInfo();
        if(info == null || !info.getCompleted()) {
            throw new TeacherInfoNotFillException();
        }
    }
}
