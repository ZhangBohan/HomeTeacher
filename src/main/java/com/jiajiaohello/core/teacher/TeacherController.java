package com.jiajiaohello.core.teacher;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.info.model.Stage;
import com.jiajiaohello.core.info.service.CourseService;
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
    @Autowired
    private CourseService courseService;

    @RequestMapping
    public String index() throws TeacherInfoNotFillException {
        verify();
        return "teacher/index";
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

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String getCourses(Model model) {
        List<Stage> stages = courseService.getStages();
        TeacherAccount teacherAccount = teacherAccountService.get(AuthHelper.getUserAccount().getUsername());

        model.addAttribute("teacherAccount", teacherAccount);
        model.addAttribute("stages", stages);
        return "teacher/course";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public String postCourses(Integer[] courseIds) {
        teacherAccountService.updateCourses(courseIds);
        return "redirect:/teacher/courses";
    }

    public void verify() throws TeacherInfoNotFillException {
        TeacherAccount teacherAccount = teacherAccountService.get(AuthHelper.getUserAccount().getUsername());
        TeacherInfo info = teacherAccount.getInfo();
        if(info == null || !info.getCompleted()) {
            throw new TeacherInfoNotFillException();
        }
    }
}
