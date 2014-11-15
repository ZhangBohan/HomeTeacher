package com.jiajiaohello.support.auth;

import com.jiajiaohello.core.account.service.ManagerAccountService;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.core.account.service.UserAccountService;
import com.jiajiaohello.support.core.CommonHelper;
import com.jiajiaohello.support.exception.CrashException;
import com.jiajiaohello.support.exception.JSONCrashException;
import com.jiajiaohello.support.sms.SMSService;
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

import javax.servlet.http.HttpServletRequest;
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
    private ManagerAccountService managerAccountService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private SMSService smsService;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(RegisterForm form, Model model) {
        model.addAttribute("form", form);
        return "auth/register";
    }
    
    @RequestMapping(value = "/login/admin", method = RequestMethod.GET)
    public String adminLogin() {
        return "auth/admin_login";
    }

    @RequestMapping(value = "/register/admin", method = RequestMethod.GET)
    public String adminRegister() {
        return "auth/admin_register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postTeacherRegister(@Valid RegisterForm form, BindingResult result, Model model) {
        model.addAttribute("form", form);
        if(result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                MessageHelper.addErrorAttribute(model, objectError.getDefaultMessage());
            }
            return "auth/register";
        }

        String key = "verifies:" + form.getPhone();
        if("1111".equals(form.getVerifyCode()) || !form.getVerifyCode().equals(jedis.get(key))) {
            MessageHelper.addErrorAttribute(model, "验证码错误");
            return "auth/register";
        }
        if(form.getAccount().equals(0)) {
            userAccountService.create(form);
            return "redirect:/auth/login/user";
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

        managerAccountService.create(form);
        return "redirect:/auth/login/admin";
    }
    @RequestMapping("/verify/{phone}")
    @ResponseBody
    public void verifyCode(@PathVariable("phone") String phone, HttpServletRequest request) throws CrashException {
        if(StringUtils.isBlank(phone) || phone.length() != 11) {
            throw new JSONCrashException("非法手机号！");
        }

        // 60秒内同IP不能重复发送
        String ip = CommonHelper.getIP(request);
        String key = "verify:ips:" + ip;
        if(jedis.get(key) != null) {
            throw new JSONCrashException("请求频繁");
        } else {
            jedis.set(key, "");
            jedis.expire(key, 60);  // 一分钟过期
        }

        key = "verify:phones:" + phone;
        String verifyCode = jedis.get(key);
        if(StringUtils.isBlank(verifyCode)) {
            verifyCode = RandomStringUtils.random(4, false, true);
        }

        CommonHelper.LOG.info("verify code. phone: " + phone + ", code: " + verifyCode);
        // 发短信到用户手机中
//        smsService.sendVerifyCode(verifyCode, phone);

        jedis.set(key, verifyCode);
        jedis.expire(key, 60 * 5); // 五分钟内有效
    }
}
