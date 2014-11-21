package com.jiajiaohello.core.recommend;

import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * User: bohan
 * Date: 11/21/14
 * Time: 11:01 AM
 */
@Entity
public class RecommendItem {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer typeId;
    private Integer rank;
    private Integer itemId;
    private String description;
    private String meta;    // JSON对象，用来存储额外信息
    @Transient
    private Object entity;  // 用于返回时存储原对象，不保存到数据库中

    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }

    @Override
    public String toString() {
        return "RecommendItem{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", rank=" + rank +
                ", itemId=" + itemId +
                ", description='" + description + '\'' +
                ", meta='" + meta + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
