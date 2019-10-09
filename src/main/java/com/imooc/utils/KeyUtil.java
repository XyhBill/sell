package com.imooc.utils;

import java.util.Random;

/**
 * @ClassName: KeyUtil
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/24 16:39
 * Version 1.0
 **/
public class KeyUtil {
    /*生成唯一的主键
    * 格式：时间+随机数
    */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
