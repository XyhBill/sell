package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName: BuyerController
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/30 15:13
 * Version 1.0
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerController {
    @Autowired
    private OrderService orderService;
    // 创建订单
    public ResultVO<Map<String , String>> create(@Valid OrderForm orderForm , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确 , orderForm={}",orderForm);
            throw new SellException(ResultEnum.OARAM_ERROE.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = new
        orderService.create()
        return null;
    }
    // 订单列表

    // 订单详情

    // 取消订单

}
