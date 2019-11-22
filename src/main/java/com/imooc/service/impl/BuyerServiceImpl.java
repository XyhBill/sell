package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BuyerServiceImpl
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/11/20 22:28
 * Version 1.0
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        return checkOrderOwner(openId, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null) {
            log.error("【查询订单】 订单的openId不一致 . openId={},orderDTO={}" , orderDTO);
            throw new SellException(ResultEnum.ORDERDetail_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openId, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        // 判断是否是当前用户自己的订单
        if (!orderDTO.getBuyerOpenid().equals(openId)){
            log.error("【查询订单】 订单的openId不一致 . openId={},orderDTO={}" , openId , orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
