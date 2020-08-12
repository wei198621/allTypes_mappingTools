package com.tz.leo.springBeanUtils.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: tz_wl
 * Date: 2020/8/12 16:06
 * Content:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderQueryParam {
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 收货人姓名/号码
     */
    private String receiverKeyword;

    /**
     * 收货人姓名/号码2
     */
    private String receiverKeyword2;
    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    private Integer status;
    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    private Integer orderType;
    private Integer orderType2;
    /**
     * 订单来源：0->PC订单；1->app订单
     */
    private Integer sourceType;
}
