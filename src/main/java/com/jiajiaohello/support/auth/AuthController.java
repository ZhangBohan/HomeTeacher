package com.jiajiaohello.support.auth;

import com.jiajiaohello.support.core.CommonHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

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

    @RequestMapping("/verify/{phone}")
    @ResponseBody
    public String verifyCode(@PathVariable("phone") String phone) {
        Jedis jedis = new Jedis("localhost");

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
