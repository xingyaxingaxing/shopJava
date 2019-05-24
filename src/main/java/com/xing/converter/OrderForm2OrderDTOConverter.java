package com.xing.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xing.dataobject.OderDetail;
import com.xing.dto.OrderDTO;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.form.OrderForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerNme(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setCreateTime(new Date());
        orderDTO.setUpdateTime(new Date());

        List<OderDetail>oderDetailList=new ArrayList<>();
    try {
        oderDetailList=gson.fromJson(orderForm.getItems(),
                new TypeToken<List<OderDetail>>() {

                }.getType());
    } catch (Exception e){
            throw new SellException(ResultEnum.PARAM_ERROR);
    }

    orderDTO.setOderDetailList(oderDetailList);

    return orderDTO;
    }
}
