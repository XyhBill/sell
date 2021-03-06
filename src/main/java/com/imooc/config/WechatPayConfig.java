package com.imooc.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){
        //WxPayH5Config wxPayH5Config = new WxPayH5Config();
        //wxPayH5Config.setAppId(accountConfig.getMpAppId());
        //wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
        //wxPayH5Config.setMchId(accountConfig.getMchId());
        //wxPayH5Config.setMchKey(accountConfig.getMchKey());
        //wxPayH5Config.setKeyPath(accountConfig.getKeyPath());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    //如果觉得上面注释的方法比较麻烦，可以向下面这样单独写出来也做一个Bean
    @Bean
    public  WxPayH5Config wxPayH5Config(){
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
        wxPayH5Config.setMchId(accountConfig.getMchId());
        wxPayH5Config.setMchKey(accountConfig.getMchKey());
        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());
        wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());
        return wxPayH5Config;
    }
}
