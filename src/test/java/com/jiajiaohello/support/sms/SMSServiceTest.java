package com.jiajiaohello.support.sms;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SMSServiceTest extends BaseTest {
    @Autowired
    private SMSService smsService;

    @Test
    public void testSend() throws Exception {
        String text = "您的验证码是1234【家教你好】";
        String phone = "15701321525";
        smsService.send(text, phone);
    }
}