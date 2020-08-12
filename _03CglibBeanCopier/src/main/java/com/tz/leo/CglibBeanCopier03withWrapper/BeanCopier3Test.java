package com.tz.leo.CglibBeanCopier03withWrapper;

import com.tz.leo.CglibBeanCopier03withWrapper.beans.Account;
import com.tz.leo.CglibBeanCopier03withWrapper.beans.AccountDto;
import net.sf.cglib.beans.BeanCopier;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/8/12 19:09
 * Content:
 */
public class BeanCopier3Test {
    public static void main(String[] args) {

        CopeOrigional();
        CopeWithWrapper();
    }


    /**
    *@Description:   原始的copy 方法  
    *@Param: 
    *@return: 
    *@date: 2020/8/12
    */
    private static void CopeOrigional() {
        Account account = new Account();
        account.setId(1);
        account.setCreateTime(new Date());
        account.setBalance(BigDecimal.valueOf(4000L));

        BeanCopier copier = BeanCopier.create(Account.class, AccountDto.class, false);
        AccountDto accountDto = new AccountDto();
        copier.copy(account, accountDto, null);

        System.out.println("==============CopeSimple1================");
        System.out.println(accountDto.getId());            //1
        System.out.println(accountDto.getBalance());       //null
        System.out.println(accountDto.getCreateTime());    //null
        System.out.println("=============CopeSimple1=================");
    }


     
    /**
    *@Description: 封装copy类 增加缓存 效果更好 
    *@Param: 
    *@return: 
    *@date: 2020/8/12
    */
    private static void CopeWithWrapper() {
        Account account = new Account();
        account.setId(1);
        account.setCreateTime(new Date());
        account.setBalance(BigDecimal.valueOf(4000L));
        AccountDto accountDto = new AccountDto();
        WrapperBeanCopier.copyProperties(account,accountDto);
        System.out.println("==============CopeWithWrapper================");
        System.out.println(accountDto.getId());            //1
        System.out.println(accountDto.getBalance());       //null
        System.out.println(accountDto.getCreateTime());    //null
        System.out.println("=============CopeWithWrapper=================");
    }


}
