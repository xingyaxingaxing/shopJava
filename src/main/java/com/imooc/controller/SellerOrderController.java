package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.exception.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    private OrderService orderService;
    /*订单列表
    * */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /*取消订单*
     */
    @GetMapping("/cancle")
    public ModelAndView cancle(@RequestParam("oderId") String oderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(oderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCLE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        //    orderService.cancel(orderDTO);
        return new ModelAndView("common/success");
    }

    /*
    订单详情
    * */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("oderId") String oderId,
                               Map<String, Object> map){
        OrderDTO orderDTO=new OrderDTO();
        try{
            orderDTO=orderService.findOne(oderId);
        }catch (SellException e){

            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("order/error",map);
        }

        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }
    /*
    订单完结
    */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("oderId") String oderId,
                               Map<String, Object> map){
        try{
            OrderDTO orderDTO=orderService.findOne(oderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success");

    }
    @GetMapping("/f")
    public ModelAndView aa(){
        return new ModelAndView("common/nav");
    }
}


