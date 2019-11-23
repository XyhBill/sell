package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay")
public class PayController {
    //因为需要查询订单 所以导入订单所需的servvice
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId ,
                                    @RequestParam("returnUrl") String returnUrl){

        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付，将逻辑都写在PayService中


    }
}