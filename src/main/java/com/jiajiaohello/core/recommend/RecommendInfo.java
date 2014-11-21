package com.jiajiaohello.core.recommend;

import java.util.List;
import java.util.Map;

/**
 * User: bohan
 * Date: 11/21/14
 * Time: 10:57 AM
 */
public class RecommendInfo<T> {
    private List<T> list;
    private Integer nextStart;
    private Integer size;
    private Integer total;
    private Map<String, Object> meta;

    public RecommendInfo() {
    }

    public RecommendInfo(List<T> list, Integer nextStart, Integer size, Integer total) {
        this.list = list;
        this.nextStart = nextStart;
        this.size = size;
        this.total = total;
    }

    public RecommendInfo(List<T> list, Integer nextStart, Integer size, Integer total, Map<String, Object> meta) {
        this.list = list;
        this.nextStart = nextStart;
        this.size = size;
        this.total = total;
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "RecommendInfo{" +
                "list=" + list +
                ", nextStart=" + nextStart +
                ", size=" + size +
                ", total=" + total +
                ", meta=" + meta +
                '}';
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getNextStart() {
        return nextStart;
    }

    public void setNextStart(Integer nextStart) {
        this.nextStart = nextStart;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}
