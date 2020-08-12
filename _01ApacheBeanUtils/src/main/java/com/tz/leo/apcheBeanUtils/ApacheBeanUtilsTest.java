package com.tz.leo.apcheBeanUtils;

import com.tz.leo.apcheBeanUtils.beans.Order;
import com.tz.leo.apcheBeanUtils.beans.OrderQueryParam;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;



/**
 * Author: tz_wl
 * Date: 2020/8/12 16:55
 * Content:
 */
public class ApacheBeanUtilsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);

        OrderQueryParam orderQueryParam = new OrderQueryParam();
        BeanUtils.copyProperties(orderQueryParam,order);  // (dest,source)
        System.out.println("orderQueryParam is : " + orderQueryParam);

    }
}
