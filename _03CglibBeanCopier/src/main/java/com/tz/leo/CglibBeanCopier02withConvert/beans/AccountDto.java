package com.tz.leo.CglibBeanCopier02withConvert.beans;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:43
 * Content:
 */
public class AccountDto {

    private int id;
    private String createTime;
    private String balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
