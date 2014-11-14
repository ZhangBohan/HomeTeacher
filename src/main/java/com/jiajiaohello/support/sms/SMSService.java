package com.jiajiaohello.support.sms;

import java.util.List;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 11:06 PM
 */
public interface SMSService {
    void send(String text, String mobile) throws SMSException;

    void sendVerifyCode(String code, String mobile) throws SMSException;

    void send(String text, List<String> mobiles) throws SMSException;
}
