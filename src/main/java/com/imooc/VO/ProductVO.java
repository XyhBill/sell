package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: 商品（包含类目）
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/8/25 12:35
 * Version 1.0
 **/
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
