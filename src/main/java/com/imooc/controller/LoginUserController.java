package com.imooc.controller;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dataobject.SellerInfo;
import com.imooc.exception.ResultEnum;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginUserController {
    @Autowired
    private SellerService sellerService;
    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "productId",required =false ) String openId,
                              Map<String,Object>map){

            SellerInfo sellerInfo=sellerService.findSellerInfoByOpenId(openId);
            map.put("sellerInfo",sellerInfo);
        return new ModelAndView("login/list",map);
        }
}
