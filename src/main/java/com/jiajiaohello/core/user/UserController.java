package com.jiajiaohello.core.user;

import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.info.model.Stage;
import com.jiajiaohello.core.info.service.CourseService;
import com.jiajiaohello.core.ticket.ClassTicketForm;
import com.jiajiaohello.core.ticket.ClassTicketService;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * User: bohan
 * Date: 11/20/14
 * Time: 6:18 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TeacherAccountService teacherAccountService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassTicketService classTicketService;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String getTicket(ClassTicketForm form, Model model) {

        if(form.getTeacherId() != null) {
            TeacherAccount teacherAccount = teacherAccountService.get(form.getTeacherId());
            model.addAttribute("teacher", teacherAccount);
        }

        List<Stage> stages = courseService.getStages();

        model.addAttribute("stages", stages);
        model.addAttribute("form", form);
        return "ticket";
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public String postTicket(@Valid ClassTicketForm form, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("result", result);
            return "ticket";
        }

        try {
            classTicketService.create(form, AuthHelper.getUsername());
        } catch (ParseException e) {
            MessageHelper.addErrorAttribute(model, "日期格式错误");
            return "ticket";
        }
        return "redirect:/user/tickets";
    }
}
