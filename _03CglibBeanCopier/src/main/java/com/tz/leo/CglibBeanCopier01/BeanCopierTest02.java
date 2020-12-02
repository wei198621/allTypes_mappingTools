package com.tz.leo.CglibBeanCopier01;

import com.tz.leo.CglibBeanCopier01.beans.User;
import com.tz.leo.CglibBeanCopier01.beans.UserDto;
import com.tz.leo.CglibBeanCopier01.beans.UserWithDiffType;
import net.sf.cglib.beans.BeanCopier;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:27
 * Content:
 */
public class BeanCopierTest02 {
    public static void main(String[] args) {
        CopyUser2UserWithDiffType();
    }




    /**
    *@Description:  User.age  (int)   UserWithDiffType.age (Integer)
     *    User  与  UserWithDiffType age   类型不一样 ， 所以可以从User.age 不可以映射到  UserWithDiffType.age
    *@Param:
    *@return:
    *@date: 2020/8/12
    */
    private static void CopyUser2UserWithDiffType() {
        final BeanCopier beanCopier = BeanCopier.create(User.class, UserWithDiffType.class, false);
        User user = new User();
        user.setAge(10);
        user.setName("zhangsan");
        UserWithDiffType userDto = new UserWithDiffType();
        beanCopier.copy(user, userDto, null);
        System.out.println("======CopyUser2UserWithDiffType========");
        System.out.println(userDto.getAge());     //null
        System.out.println(userDto.getName());    //zhangsan
        System.out.println("======CopyUser2UserWithDiffType========");
    }

}
