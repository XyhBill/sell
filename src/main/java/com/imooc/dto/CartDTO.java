package com.imooc.dto;

import lombok.Data;

/**
 * @ClassName: CartDTO
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/24 16:54
 * Version 1.0
 **/
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
