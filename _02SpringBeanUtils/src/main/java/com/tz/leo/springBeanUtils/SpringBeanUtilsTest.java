package com.tz.leo.springBeanUtils;


import com.tz.leo.springBeanUtils.beans.Order;
import com.tz.leo.springBeanUtils.beans.OrderQueryParam;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;


/**
 * Author: tz_wl
 * Date: 2020/8/12 16:55
 * Content:
 */
public class SpringBeanUtilsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);

        OrderQueryParam orderQueryParam = new OrderQueryParam();
        BeanUtils.copyProperties(order,orderQueryParam);  //(source,dest)
        System.out.println("通过springframework的BeanUtils，  orderQueryParam is : " + orderQueryParam);

    }
}
