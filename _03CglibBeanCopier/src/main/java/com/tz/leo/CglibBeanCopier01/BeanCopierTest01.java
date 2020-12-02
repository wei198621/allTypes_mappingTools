package com.tz.leo.CglibBeanCopier01;

import com.tz.leo.CglibBeanCopier01.beans.User;
import com.tz.leo.CglibBeanCopier01.beans.UserDto;
import net.sf.cglib.beans.BeanCopier;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:27
 * Content:
 */
public class BeanCopierTest01 {
    public static void main(String[] args) {
        CopyUser2UserDto();
    }

    /**
    *@Description:  User.age  (int)   UserDto.age (int)
     * User  与  UserDto age  name  都是相同类型 所以可以从User映射到UserDto
    *@Param:
    *@return:
    *@date: 2020/8/12
    */
    private static void CopyUser2UserDto() {
        final BeanCopier beanCopier = BeanCopier.create(User.class, UserDto.class, false);
        User user = new User();
        user.setAge(10)        ;
        user.setName("zhangsan01");
        UserDto userDto = new UserDto();
        beanCopier.copy(user,userDto,null);

        System.out.println("======CopyUser2UserDto========");
        System.out.println(userDto.getAge());
        System.out.println(userDto.getName());
        System.out.println("======CopyUser2UserDto========");
    }



}
