package com.jiajiaohello.core.admin;


import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.service.ManagerAccountService;
import com.jiajiaohello.core.admin.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.web.MessageHelper;


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
        if(result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(redirectAttributes, objectError.getDefaultMessage());
            }
        } else {
        	managerAccountService.update(editForm);
            MessageHelper.addSuccessAttribute(redirectAttributes, "更新成功！");
        }
        return "redirect:/admin/edit";
    }
}
