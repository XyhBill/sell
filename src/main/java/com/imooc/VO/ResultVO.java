package com.imooc.VO;

import lombok.Data;

/**
 * @ClassName: http请求返回的最外层对象
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/8/24 23:19
 * Version 1.0
 **/
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
