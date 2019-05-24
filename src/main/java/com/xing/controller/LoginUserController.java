package com.xing.controller;

import com.xing.dataobject.SellerInfo;
import com.xing.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
