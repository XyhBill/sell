package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl service;
    @Test
    public void findOne() throws Exception {
        ProductInfo info = service.findOne("123456");
        Assert.assertEquals("123456",info.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> infoList = service.findUpAll();
        Assert.assertNotEquals(0,infoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> infoList = service.findAll(request);
        // System.out.println(infoList.getTotalElements());
        Assert.assertNotEquals(0,infoList.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("3215426");
        productInfo.setProductName("龙虾");
        productInfo.setProductPrice(new BigDecimal("3.5"));
        productInfo.setProductStock(101);
        productInfo.setProductDescription("超好吃的");
        productInfo.setProductIcon("http://yyy.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);
    }
}