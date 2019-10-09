package com.imooc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OrderForm2OrderDTOConverter
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/30 15:35
 * Version 1.0
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDT = new OrderDTO();

        orderDT.setBuyerName(orderForm.getName());
        orderDT.setBuyerPhone(orderForm.getPhone());
        orderDT.setBuyerAddress(orderForm.getAddress());
        orderDT.setBuyerOpenid(orderForm.getOpenId());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            gson.fromJson(orderForm.getItems() , new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            log.error("【对象转换】 错误, string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDT.setOrderDetailList(orderDetailList);

        return orderDT;
    }
}
