package com.imooc.service.impl;

import com.imooc.dataobject.OderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    private final  String BUYR_OPENID="110110";
    private final String ORDER_ID="1556198382576286993";
    @Test
    public void create()throws Exception {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerNme("兴哥");
        orderDTO.setBuyerAddress("贵州大学");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYR_OPENID);

        //购物车
        List<OderDetail>oderDetailList=new ArrayList<>();
        OderDetail o1=new OderDetail();
        o1.setProductId("1234568");
        o1.setProductQuantity(1);
        o1.setCreateTime(new Date());
        o1.setUpdateTime(new Date());
        oderDetailList.add(o1);

        OderDetail o2=new OderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);
        o2.setCreateTime(new Date());
        o2.setUpdateTime(new Date());
        oderDetailList.add(o2);
        orderDTO.setOderDetailList(oderDetailList);
        OrderDTO result=orderService.create(orderDTO);

    }

    @Test
    public void findOne() {
        OrderDTO result=orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID,result.getOderId());
    }

    @Test
    public void findList() throws Exception{
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO>orderDTOPage=orderService.findList(BUYR_OPENID,pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel()throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
        //该方法出错会显示出期望信息

    }

    @Test
    public void list() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO>orderDTOPage=orderService.findList(BUYR_OPENID,request);
      //  Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("查询订单列表",orderDTOPage.getTotalElements()>0);
        //该方法出错会打印出提示信息
    }
}