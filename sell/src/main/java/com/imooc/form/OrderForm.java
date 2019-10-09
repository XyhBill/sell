package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName: OrderForm
 * @Description: 用来给页面进行表单验证的类
 * @Author BillXie
 * @Date 2019/9/30 15:16
 * Version 1.0
 **/
@Data
public class OrderForm {
    // 买家姓名
    @NotEmpty(message = "姓名必填")
    private String name;
    // 买家手机号
    @NotEmpty(message = "手机号必填")
    private String phone;
    // 买家地址
    @NotEmpty(message = "地址必填")
    private String address;
    // 买家openId
    @NotEmpty(message = "poenId必填")
    private String openId;
    // 购物车信息
    @NotEmpty(message = "购物车信息")
    private String items;
}
