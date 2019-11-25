package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static  final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        //BestPayServiceImpl类是引入依赖后使用，此时就使用里面的pay方法，要引入配置
        //进入下面set方法里面，进入传参实体类中就可以看见需要配置的属性
        PayRequest payRequest = new PayRequest();
        //以下是使用这个sdk需要提供的参数
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        //商品金额，是bigdecaul类型要转成double类型才能接收
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】 request={}" , JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】 response={}" , JsonUtil.toJson(payResponse));
        return payResponse;
    }
}
