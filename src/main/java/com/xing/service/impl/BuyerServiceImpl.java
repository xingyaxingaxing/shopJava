package com.xing.service.impl;

import com.xing.dto.OrderDTO;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.service.BuyerService;
import com.xing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String oderId) {
      return checkOrderOwner(openid,oderId);
    }

    @Override
    public OrderDTO cancleOrder(String openid, String oderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,oderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid,String oderId){
        OrderDTO orderDTO=orderService.findOne(oderId);
        if(orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
