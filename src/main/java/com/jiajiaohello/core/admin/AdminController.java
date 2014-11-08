package com.jiajiaohello.core.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiajiaohello.core.account.service.ManagerAccountService;


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

}
