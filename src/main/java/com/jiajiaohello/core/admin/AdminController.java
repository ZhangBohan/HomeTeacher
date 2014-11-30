package com.jiajiaohello.core.admin;


import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.jiajiaohello.core.teacher.dto.TeacherEditForm;
import com.jiajiaohello.core.ticket.ClassTicket;
import com.jiajiaohello.core.ticket.ClassTicketService;
import com.jiajiaohello.core.ticket.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.core.account.service.ManagerAccountService;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.account.service.UserAccountService;
import com.jiajiaohello.core.admin.dto.EditForm;
import com.jiajiaohello.core.audit.service.AuditService;
import com.jiajiaohello.core.teacher.dto.SearchForm;
import com.jiajiaohello.core.teacher.dto.VerifyForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.web.MessageHelper;
import com.jiajiaohello.support.web.Pager;


/**
 * User: bohan
 * Date: 10/8/14
 * Time: 10:43 PM
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ManagerAccountService managerAccountService;
    @Autowired
    private TeacherAccountService teacherAccountService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private AuditService auditService;
    @Autowired
    private ClassTicketService classTicketService;

    @RequestMapping
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(Model model) {
        ManagerAccount adminAccount = managerAccountService.get(AuthHelper.getUserAccount().getUsername());
        model.addAttribute("adminAccount", adminAccount);
        return "admin/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@Valid EditForm editForm, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(redirectAttributes, objectError.getDefaultMessage());
            }
        } else {
            managerAccountService.update(editForm);
            MessageHelper.addSuccessAttribute(redirectAttributes, "更新成功！");
        }
        return "redirect:/admin/edit";
    }

    @RequestMapping(value = "/teacher/show", method = RequestMethod.GET)
    public String getShowTeacher(Model model, SearchForm searchform, Pager page) {
        List<TeacherAccount> teacherAccountList = teacherAccountService.getTeacherAccountsByCondition(searchform, page);
        model.addAttribute("teacherAccountList", teacherAccountList);
        model.addAttribute("page", page);
        return "admin/teacher/show";
    }

    @RequestMapping(value = "/teacher/verify", method = RequestMethod.GET)
    public String getAudits(Model model, SearchForm searchform, Pager page) {
        if (page.getTotal() == -1) {
            int count = teacherAccountService.getCount();
            page.setTotal(count);
        }
        TeacherAccount account = new TeacherAccount();
        account.setUsername(searchform.getUsername());
        TeacherInfo info = new TeacherInfo();
        info.setDescription(searchform.getDescription());
        info.setFreeTime(searchform.getFreeTime());
        info.setIdentity(searchform.getIdentity());
        info.setAudited(false);
        account.setName(searchform.getName());
        info.setSex(searchform.getSex());
        account.setUsername(searchform.getUsername());
        account.setInfo(info);
        List<TeacherAccount> teacherAccountList = teacherAccountService.getTeacherAccounts(account, page.getOffset(), page.getMaxResult());
        model.addAttribute("teacherAccountList", teacherAccountList);
        model.addAttribute("page", page);
        return "admin/teacher/verify";
    }

    @RequestMapping(value = "/user/show", method = RequestMethod.GET)
    public String getShowUser(Model model, SearchForm searchform, Pager page) {
        List<UserAccount> userAccountList = userAccountService.getUserAccountsByCondition(searchform, page);
        model.addAttribute("userAccountList", userAccountList);
        model.addAttribute("page", page);
        return "admin/user/show";
    }

    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verityTeacher(VerifyForm verifyform) {
        teacherAccountService.verityTeacher(verifyform);
        return "redirect:/admin/teacher/verify";
    }

    @RequestMapping(value = "/teacher/edit", method = RequestMethod.GET)
    public String editTeacher(Model model, String username) {
        TeacherAccount teacherAccount = teacherAccountService.get(username);
        model.addAttribute("teacherAccount", teacherAccount);
        return "admin/teacher/edit";
    }

    @RequestMapping(value = "/teacher/edit", method = RequestMethod.POST)
    public String postEditTeacher(@Valid TeacherEditForm teacherEditForm, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if (result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(redirectAttributes, objectError.getDefaultMessage());
            }
        } else {
            teacherAccountService.updateTeacher(teacherEditForm);
            MessageHelper.addSuccessAttribute(redirectAttributes, "更新成功！");
        }
        return "redirect:/admin/teacher/edit";
    }

    @RequestMapping(value = "/recommends")
    public String recommends() {
        return "admin/recommends";
    }

    @RequestMapping(value = "/recommends/{recommendId}")
    public String recommend(@PathVariable("recommendId") Integer recommendId, Model model) {
        model.addAttribute("recommendId", recommendId);
        return "admin/recommend";
    }

    @RequestMapping(value = "ticket", method = RequestMethod.GET)
    public String ticket(Model model) {
        List<ClassTicket> classTickets = classTicketService.getClassTickets(TicketStatus.open);
        model.addAttribute("classTickets", classTickets);
        return "admin/ticket";
    }
}
