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

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String userLogin() {
        return "auth/user_login";
    }
}
