package com.imooc.service;

import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @Test
    public void create() throws Exception {
        //平常使用测试类的时候，可以直接用id查找，免得手动新建数据麻烦
        OrderDTO orderDTO = orderService.findOne("23423524234");
        payService.create(orderDTO);
    }
}