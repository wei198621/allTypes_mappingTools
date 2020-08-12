package com.tz.leo.CglibBeanCopier02withConvert;

import com.tz.leo.CglibBeanCopier02withConvert.beans.Account;
import com.tz.leo.CglibBeanCopier02withConvert.beans.AccountDto;
import com.tz.leo.CglibBeanCopier02withConvert.converters.AccountConverter;
import net.sf.cglib.beans.BeanCopier;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:44
 * Content:   类型不一样的转换时候需要 使用converter 转换其中的类型
 */
public class BeanCopier2Test {
    public static void main(String[] args) {

        CopeSimple();

        CopyWithConverter();

    }


    private static void CopeSimple() {
        Account po = new Account();
        po.setId(1);
        po.setCreateTime(new Date());
        po.setBalance(BigDecimal.valueOf(4000L));
        BeanCopier copier = BeanCopier.create(Account.class, AccountDto.class, false);
        AccountDto dto = new AccountDto();
        copier.copy(po, dto, null);
        System.out.println("==============CopeSimple================");
        System.out.println(dto.getId());            //1
        System.out.println(dto.getBalance());       //null
        System.out.println(dto.getCreateTime());    //null
        System.out.println("=============CopeSimple=================");
    }

    private static void CopyWithConverter() {
        Account po = new Account();
        po.setId(1);
        po.setCreateTime(new Date());
        po.setBalance(BigDecimal.valueOf(4000L));
        BeanCopier copier = BeanCopier.create(Account.class, AccountDto.class, true);
        AccountDto dto = new AccountDto();
        AccountConverter converter = new AccountConverter();
        copier.copy(po, dto, converter);
        //注：一旦使用Converter，BeanCopier只使用Converter定义的规则去拷贝属性，所以在convert方法中要考虑所有的属性。

        System.out.println("==========CopyWithConverter====================");
        System.out.println(dto.getId());            //1
        System.out.println(dto.getBalance());       //4000
        System.out.println(dto.getCreateTime());    //2020-08-12
        System.out.println("=========CopyWithConverter=====================");

        /*// 类型不同，未拷贝
        Assert.assertEquals("4000", dto.getBalance());
        // 类型不同，未拷贝
        Assert.assertEquals("2018-12-13", dto.getCreateTime());*/
    }

}
