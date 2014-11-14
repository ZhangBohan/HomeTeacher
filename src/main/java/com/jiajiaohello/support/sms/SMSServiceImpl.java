package com.jiajiaohello.support.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiajiaohello.support.core.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 11:08 PM
 */
@Service
public class SMSServiceImpl implements SMSService {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void send(String text, String mobile) throws SMSException {
        try {
            String resultString = YunPianSMSFactory.sendSms(text, mobile);
            CommonHelper.LOG.debug("Message" + mobile + ", " + text + ", " + resultString);
            SMSResult SMSResult = mapper.readValue(resultString, SMSResult.class);
            if(SMSResult.isNotSuccess()) {
                CommonHelper.LOG.error("SMS ERROR: " + resultString);
                throw new SMSException();
            }
        } catch (IOException e) {
            CommonHelper.LOG.error("SMS ERROR: " + e.getMessage(), e);
            throw new SMSException();
        }
    }

    @Override
    public void send(String text, List<String> mobiles) throws SMSException {
        for (String mobile : mobiles) {
            send(text, mobile);
        }

    }
}
