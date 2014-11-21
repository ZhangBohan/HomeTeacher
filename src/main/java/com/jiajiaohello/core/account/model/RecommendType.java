package com.jiajiaohello.core.account.model;

/**
 * 该类保存数据为推荐教员类型
 *
 * User: bohan
 * Date: 11/5/14
 * Time: 4:09 PM
 */
public enum RecommendType {
    top(1),
    row1(2),
    row2(3),
    row3(4);
    private Integer id;

    public static RecommendType getInstance(Integer id) {
        for (RecommendType recommendType : RecommendType.class.getEnumConstants()) {
            if(recommendType.getId().equals(id)) {
                return recommendType;
            }
        }

        return null;
    }

    RecommendType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
