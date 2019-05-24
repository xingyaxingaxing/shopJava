package com.xing.controller;

import com.xing.VO.ResultVO;
import com.xing.converter.OrderForm2OrderDTOConverter;
import com.xing.dto.OrderDTO;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.form.OrderForm;
import com.xing.service.BuyerService;
import com.xing.service.OrderService;
import com.xing.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>>create(@Valid OrderForm orderForm,
                                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult=orderService.create(orderDTO);
        Map<String,String>map=new HashMap<>();
        map.put("oderId",createResult.getOderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>>list(@RequestParam("openid")String openid,
                                        @RequestParam(value = "page",defaultValue = "0")Integer page,
                                        @RequestParam(value = "size",defaultValue = "10")Integer size){
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO>orderDTOPage=orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());

    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO>detail(@RequestParam("openid")String openid,
                                    @RequestParam("oderid")String oderId){
       OrderDTO orderDTO=buyerService.findOrderOne(openid,oderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancle")
    public ResultVO cancledetail(@RequestParam("openid")String openid,
                                 @RequestParam("oderid")String oderId){
        buyerService.cancleOrder(openid,oderId);
        return ResultVOUtil.success();
    }
}
