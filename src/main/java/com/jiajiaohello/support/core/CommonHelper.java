package com.jiajiaohello.support.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:36 PM
 */
public class CommonHelper {
    public static final Log LOG = LogFactory.getLog("root");

    public static Date now() {
        return new Date();
    }
}
