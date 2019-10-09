package com.imooc.enums;

import lombok.Getter;

/**
 * @ClassName: ResultEnum
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/23 11:31
 * Version 1.0
 **/
@Getter
public enum  ResultEnum {
    OARAM_ERROE(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROR(11,"商品库存不足"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDERDetail_NOT_EXIST(13,"订单不存在"),
    
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    
    ORDER_DETAIL_EMPTY(16,"订单详情无商品"),

    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
