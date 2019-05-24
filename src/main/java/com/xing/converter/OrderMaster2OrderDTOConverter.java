package com.xing.converter;

import com.xing.dataobject.OrderMaster;
import com.xing.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {
    public static OrderDTO conver(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        //orderDTO.getOrderStatusEnum();
        //orderDTO.getPayStatusEnum();
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster>orderMasterList){

        return orderMasterList.stream().map(e->
                conver(e)
        ).collect(Collectors.toList());
    }
}
