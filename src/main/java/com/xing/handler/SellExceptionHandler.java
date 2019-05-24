package com.xing.handler;

import com.xing.config.ProjectUrlConfig;
import com.xing.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        //getWechatOpenAuthorize()进行授权
        return new ModelAndView("redirect:"
        .concat("/user/login"));
    }
}
