package com.imooc.service;

import com.imooc.dto.OrderDTO;

public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String oderId);

    //取消一个订单
    OrderDTO cancleOrder(String openid,String oderId);
}
