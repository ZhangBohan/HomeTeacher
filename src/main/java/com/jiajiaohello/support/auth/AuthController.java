package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.service.ManagerAccountService;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.support.core.CommonHelper;
import com.jiajiaohello.support.web.MessageHelper;
import org.apache.commons.lang3.BooleanUtils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import javax.validation.Valid;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 5:30 PM
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private TeacherAccountService teacherAccountService;
    @Autowired
    private ManagerAccountService mannagerAccountService;

    Jedis jedis = new Jedis("localhost");

    @RequestMapping(value = "/login/user", method = RequestMethod.GET)
    public String userLogin() {
        return "auth/user_login";
    }

    @RequestMapping(value = "/login/teacher", method = RequestMethod.GET)
    public String teacherLogin(Boolean error, Model model) {
        if(BooleanUtils.isTrue(error)) {
            MessageHelper.addErrorAttribute(model, "用户名或密码错误！");
        }
        return "auth/teacher_login";
    }

    @RequestMapping(value = "/register/teacher", method = RequestMethod.GET)
    public String teacherRegister(RegisterForm form, Model model) {
        model.addAttribute("form", form);
        return "auth/teacher_register";
    }
    
    @RequestMapping(value = "/login/admin", method = RequestMethod.GET)
    public String adminLogin() {
        return "auth/admin_login";
    }

    @RequestMapping(value = "/register/admin", method = RequestMethod.GET)
    public String adminRegister() {
        return "auth/admin_register";
    }

    @RequestMapping(value = "/register/teacher", method = RequestMethod.POST)
    public String postTeacherRegister(@Valid RegisterForm form, BindingResult result, Model model) {
        model.addAttribute("form", form);
        if(result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(model, objectError.getDefaultMessage());
            }
            return "auth/teacher_register";
        }

        String key = "verifies:" + form.getPhone();
        if(!form.getVerifyCode().equals(jedis.get(key))) {
            MessageHelper.addErrorAttribute(model, "验证码错误");
            return "auth/teacher_register";
        }

        teacherAccountService.create(form);
        return "redirect:/auth/login/teacher";
    }
    @RequestMapping(value = "/register/admin", method = RequestMethod.POST)
    public String postAdminRegister(@Valid RegisterForm form, BindingResult result, Model model) {
        if(result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(model, objectError.getDefaultMessage());
            }
            return "auth/admin_register";
        }

        String key = "verifies:" + form.getPhone();
        if(!form.getVerifyCode().equals(jedis.get(key))) {
            MessageHelper.addErrorAttribute(model, "验证码错误");
            return "auth/admin_register";
        }

        mannagerAccountService.create(form);
        return "redirect:/auth/login/admin";
    }
    @RequestMapping("/verify/{phone}")
    @ResponseBody
    public String verifyCode(@PathVariable("phone") String phone) {

        String key = "verifies:" + phone;

        String verifyCode = jedis.get(key);
        if(StringUtils.isBlank(verifyCode)) {
            verifyCode = RandomStringUtils.random(4, false, true);
        }

        CommonHelper.LOG.info("verify code. phone: " + phone + ", code: " + verifyCode);
        //TODO 发短信到用户手机中

        jedis.set(key, verifyCode);
        jedis.expire(key, 60 * 5); // 五分钟内有效

        return verifyCode;
    }
}
