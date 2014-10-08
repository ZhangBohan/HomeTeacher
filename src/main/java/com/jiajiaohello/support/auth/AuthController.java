package com.jiajiaohello.support.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 5:30 PM
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/login/user", method = RequestMethod.GET)
    public String userLogin() {
        return "auth/user_login";
    }

    @RequestMapping(value = "/login/teacher", method = RequestMethod.GET)
    public String teacherLogin() {
        return "auth/teacher_login";
    }
}
