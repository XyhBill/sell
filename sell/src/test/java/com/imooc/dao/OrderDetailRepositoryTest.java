package com.imooc.dao;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() throws Exception{
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("5646132564");
        orderDetail.setOrderId("2221111222");
        orderDetail.setProductIcon("http://yyyy.jpg");
        orderDetail.setProductId("222221");
        orderDetail.setProductName("波士顿龙虾");
        orderDetail.setProductPrice(new BigDecimal(5.1));
        orderDetail.setProductQuantity(3);

        OrderDetail resutl = repository.save(orderDetail);
        Assert.assertNotNull(resutl);
    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("2221111222");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}