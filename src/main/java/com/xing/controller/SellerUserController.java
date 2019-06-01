package com.xing.controller;

import com.xing.config.ProjectUrlConfig;
import com.xing.constant.CookieConstant;
import com.xing.constant.RedisConstant;
import com.xing.dataobject.SellerInfo;
import com.xing.exception.ResultEnum;
import com.xing.form.SellerForm;
import com.xing.service.SellerService;
import com.xing.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

   @PostMapping("/login")
   public ModelAndView login(@Valid SellerForm form,
                             HttpServletResponse response,
                             Map<String,Object>map){
       //openid和数据库的数据匹配
       SellerInfo sellerInfo=sellerService.findSellerInfoByOpenId(form.getOpenId());
       if(sellerInfo==null){
           map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
           map.put("url","/sell/user/login");
           return new ModelAndView("/common/error");
       }
       else if (form.getPassWord().equals(sellerInfo.getPassWord())==true)
       {
           //设置token至redis
           String token= UUID.randomUUID().toString();
           Integer expire= RedisConstant.EXPIRE;
           redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),form.getOpenId(),expire, TimeUnit.SECONDS);

           //设置token至cookie
           CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
           //map.put("url","/seller/order/list");
           return new ModelAndView("redirect:"+"/seller/order/list");
           //return new ModelAndView("redirect:"+projectUrlConfig.getSell());

       }

       map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
       map.put("url","/sell/user/login");
       return new ModelAndView("/common/error");
   }





   // @GetMapping("/login")
   // public ModelAndView login(@RequestParam("openId")String openId,
   //                           HttpServletResponse response,
   //                           Map<String,Object>map){
   //     //openid和数据库的数据匹配
   //     SellerInfo sellerInfo=sellerService.findSellerInfoByOpenId(openId);
   //     if(sellerInfo==null){
   //         map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
   //         map.put("url","/sell/seller/order/list");
   //         return new ModelAndView("/common/error");
   //     }
   //     //设置token至redis
   //     String token= UUID.randomUUID().toString();
   //     Integer expire= RedisConstant.EXPIRE;
   //     redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openId,expire, TimeUnit.SECONDS);
//
   //     //设置token至cookie
   //     CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
   //     return new ModelAndView("redirect:"+"/seller/order/list");
   // }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object>map){
        //从cookie里查询
        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null){
            //清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));

            //清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/user/login");
        return new ModelAndView("common/success",map);
    }
}
