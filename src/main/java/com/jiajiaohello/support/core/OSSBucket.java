package com.jiajiaohello.support.core;

/**
 * User: bohan
 * Date: 10/27/14
 * Time: 11:01 PM
 */
public enum OSSBucket {
    avatar("jjh-avatar"),
    info("jjh-info")
    ;

    OSSBucket(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
