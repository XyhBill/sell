package com.imooc.converter;

import com.imooc.dto.OrderDTO;
import com.imooc.form.OrderForm;

/**
 * @ClassName: OrderForm2OrderDTOConverter
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/30 15:35
 * Version 1.0
 **/
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenId());

        orderDTO
    }
}
