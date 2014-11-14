package com.jiajiaohello.support.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User: bohan
 * Date: 11/14/14
 * Time: 11:37 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSResult {
    private Integer code;

    public boolean isNotSuccess() {
        return code != 0;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
