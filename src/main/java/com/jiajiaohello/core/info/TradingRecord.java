package com.jiajiaohello.core.info;

import com.jiajiaohello.core.account.model.Account;
import com.jiajiaohello.support.core.CommonHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/25/14
 * Time: 10:09 AM
 */
@Entity
public class TradingRecord {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Account account;
    private String descrption;
    private Integer money;    // 单位为分
    private Boolean success;
    private Date createdAt;
    private Date updatedAt;

    public void init() {
        this.success = Boolean.FALSE;
        this.createdAt = CommonHelper.now();
        this.updatedAt = CommonHelper.now();
    }


}
