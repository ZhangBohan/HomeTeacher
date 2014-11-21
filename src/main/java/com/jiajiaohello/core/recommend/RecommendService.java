package com.jiajiaohello.core.recommend;

import com.jiajiaohello.core.account.model.RecommendType;

import java.util.List;

/**
 * User: bohan
 * Date: 11/21/14
 * Time: 10:55 AM
 */
public interface RecommendService<T> {
    List<RecommendItem> getRecommendList(RecommendType recommendType, Integer start, Integer size);

    List<RecommendItem> getRecommendList(RecommendType recommendType);

    RecommendItem save(RecommendType recommendType, RecommendItem item);

    RecommendItem update(RecommendType recommendType, RecommendItem item);

    void delete(Integer id);
}
