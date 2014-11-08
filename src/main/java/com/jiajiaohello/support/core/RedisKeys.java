package com.jiajiaohello.support.core;

/**
 * User: bohan
 * Date: 11/7/14
 * Time: 2:29 PM
 */
public enum RedisKeys {
    recommendTeachers("recommend:teachers:%s", "首页推荐教员");

    private String keyBase;
    private String description;

    RedisKeys(String keyBase, String description) {
        this.keyBase = keyBase;
        this.description = description;
    }

    public String getKey(Object ... obj) {
        return String.format(keyBase, obj);
    }

    public String getKey() {
        return keyBase;
    }
}
