package com.tz.leo.MapStruts;

import com.tz.leo.MapStruts.beans.Order;
import com.tz.leo.MapStruts.beans.OrderQueryParam;
import com.tz.leo.MapStruts.mappers.OrderMapper;
import org.mapstruct.factory.Mappers;

/**
 * Author: tz_wl
 * Date: 2020/8/12 16:08
 * Content:
 */
public class MapStructTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);
        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);
        System.out.println(orderQueryParam.getOrderSn());
        System.out.println(orderQueryParam.getReceiverKeyword());
    }

}
