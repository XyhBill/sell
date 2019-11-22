package com.imooc.service;

import com.imooc.dto.OrderDTO;

public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openId , String orderId);
    // 取消订单
    OrderDTO cancelOrder(String openId , String orderId);
}
