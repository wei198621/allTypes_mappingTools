package com.tz.leo.BeanCopierVSBeanUtils;

import com.tz.leo.BeanCopierVSBeanUtils.beans.User;
import com.tz.leo.BeanCopierVSBeanUtils.beans.UserDto;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: tz_wl
 * Date: 2020/8/12 20:33
 * Content:  BeanCopier  速度非常快
 */
public class appTest {
    public static void main(String[] args) {
        List<User> list1 = new ArrayList<User>(9900000);
        for (int i = 0; i < 100; i++) {
            User po = new User();
            po.setAge(1);
            po.setName("lili"+ (new Random()).toString());
            list1.add(po);
        }
        BeanCopier copier = BeanCopier.create(User.class, UserDto.class, false);

        //*************************** BeanUtils  9900000 用时测试  ************************************
        long startBeanUtils = System.currentTimeMillis();
        System.out.println("BeanUtils start time is :" +startBeanUtils);
        List<UserDto> list2 = new ArrayList<UserDto>(9900000);
        for (User user : list1) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(user, dto);   //270 ms
            list2.add(dto);
        }

        long endBeanUtils =System.currentTimeMillis();
        System.out.println("BeanUtils end time is   :" + endBeanUtils );
        System.out.printf("BeanUtils took time: %d(ms)%n", endBeanUtils - startBeanUtils);

        //************************** BeanCopier  9900000 用时测试 *************************************
        System.out.println("====================================================");
        long startBeanCopier = System.currentTimeMillis();
        System.out.println("BeanCopie start time is :" +startBeanCopier);
        for (User user : list1) {
            UserDto dto = new UserDto();
            copier.copy(user, dto, null);      //20 ms
            list2.add(dto);
        }
        long endBeanCopier =System.currentTimeMillis();
        System.out.println("BeanCopie rend time is  :" + endBeanCopier );
        System.out.printf("BeanCopier took time: %d(ms)%n", endBeanCopier - startBeanCopier);

    }
}
