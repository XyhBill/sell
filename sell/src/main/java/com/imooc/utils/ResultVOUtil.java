package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * @ClassName: ResultVOUtil
 * @Description: TODO
 * @Author BillXie
 * @Date 2019/9/2 16:33
 * Version 1.0
 **/
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer code , String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setCode(1);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
