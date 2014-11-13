package com.jiajiaohello.support.core;

/**
 * User: bohan
 * Date: 11/7/14
 * Time: 2:29 PM
 */
public enum RedisKeys {
    // 首页推荐教员
    recommendTeachers("recommend:teachers:%s");

    private String keyBase;

    RedisKeys(String keyBase) {
        this.keyBase = keyBase;
    }

    public String getKey(Object ... obj) {
        return String.format(keyBase, obj);
    }

    public String getKey() {
        return keyBase;
    }
}
