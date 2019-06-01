package com.xing.controller;

import com.xing.VO.ResultVO;
import com.xing.converter.BuyerInfoForm2Converter;
import com.xing.dataobject.BuyerInfo;
import com.xing.dataobject.OrderMaster;
import com.xing.dto.BuyerInfoDTO;
import com.xing.dto.OrderDTO;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.form.AwaitPaidForm;
import com.xing.form.BuyerInfoForm;
import com.xing.form.BuyerLodinForm;
import com.xing.service.BuyerInfoService;
import com.xing.service.OrderService;
import com.xing.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/buyer/user")
public class BuyerController {
    @Autowired
    private BuyerInfoService buyerInfoService;
    @Autowired
    private OrderService orderService;
    /*用户创建*/
    @PostMapping("/createSave")
    //@Valid 用于验证注解是否符合要求,直接加在变量user之前,在变量中添加验证信息的要求,
    // 当不符合要求时就会在方法中返回message 的错误提示信息
    public ResultVO<Map<String, String>> createBuyer(@Valid BuyerInfoForm buyerInfoForm,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnum.USER_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        BuyerInfoDTO buyerInfoDTO = BuyerInfoForm2Converter.convertBuyer(buyerInfoForm);
        buyerInfoService.createBuyer(buyerInfoDTO);
        return ResultVOUtil.login(1,"成功");
    }
    /*查用户登录*/
   @PostMapping("/login")
   public ResultVO<Map<String, String>> login(@Valid BuyerLodinForm buyerInfoForm,
                                              BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           throw new SellException(ResultEnum.USER_ERROR.getCode(),
                   bindingResult.getFieldError().getDefaultMessage());
       }
       //openid和数据库的数据匹配
       Integer code=0;
       String msg="";
       BuyerInfo buyerInfo=buyerInfoService.findBuyerInfoByOpenId(buyerInfoForm.getBuyerId());
       if(buyerInfo==null){
           code=1;
           msg="该用户不存在";
           return ResultVOUtil.login(code,msg);
       }
        else if(buyerInfoForm.getPassWord().equals(buyerInfo.getPassWord())==false){
           code=2;
           msg="密码错误";
       }
       else if(buyerInfoForm.getPassWord().equals(buyerInfo.getPassWord())){
           code=3;
           msg="登录成功";
       }
       else {
            code=4;
            msg="参数异常";
        }
       return ResultVOUtil.login(code,msg);
   }
   /*查询订单详情*/
    @GetMapping("/detailList")
    public ResultVO<Map<String,String>> detail(@RequestParam("oderId") String oderId){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO=orderService.findOne(oderId);
        return ResultVOUtil.success(orderDTO);
    }
    /*支付订单*/
    @PostMapping("/awaitPaid")
    public ResultVO<Map<String,String>> awaitPaid(@Valid AwaitPaidForm awaitPaidForm,
                                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.ORDER_FORM.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderMaster orderMaster=new OrderMaster();
        orderMaster=orderService.AfindOne(awaitPaidForm.getOderId());
        BeanUtils.copyProperties(awaitPaidForm,orderMaster);
        orderMaster.setPayStatus(1);
        orderMaster.setUpdateTime(new Date());
        orderService.save(orderMaster);
        return ResultVOUtil.success(orderService.save(orderMaster));
    }
}