package com.tz.leo.MapStruts.mappers;

import com.tz.leo.MapStruts.beans.Order;
import com.tz.leo.MapStruts.beans.OrderQueryParam;
import org.mapstruct.Mapper;

/**
 * Author: tz_wl
 * Date: 2020/8/12 16:07
 * Content:
 */
//只有一个要求， 在接口上写 @Mapper 注解即可
@Mapper
public interface OrderMapper {
    OrderQueryParam entity2queryParam(Order order);
}
