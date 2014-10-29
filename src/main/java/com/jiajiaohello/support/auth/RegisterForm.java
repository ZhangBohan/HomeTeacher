package com.jiajiaohello.support.auth;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * User: bohan
 * Date: 10/29/14
 * Time: 6:44 PM
 */
public class RegisterForm {
    @Size(min = 11, max = 11, message = "请输入11位的手机号")
    private String phone;
    @Size(min = 6, max = 20, message = "密码长度需在6到22之间")
    private String password;
    private String repeatPassword;
    private Integer role;
    @Size(min = 4, max = 4, message = "请输入正确的验证码")
    private String verifyCode;

    @AssertTrue(message="密码与验证密码不相同")
    private boolean isValid() {
        return this.password.equals(this.repeatPassword);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
