package com.tz.leo.CglibBeanCopier03withWrapper.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:43
 * Content:
 */
public class Account {
    private int id;
    private Date createTime;
    private BigDecimal balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
