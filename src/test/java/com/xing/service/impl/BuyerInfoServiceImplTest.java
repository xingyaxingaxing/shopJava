//package com.xing.service.impl;
//
//import com.xing.dataobject.BuyerInfo;
//import com.xing.dto.BuyerInfoDTO;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BuyerInfoServiceImplTest {
//    @Autowired
//    private BuyerInfoServiceImpl buyerInfoService;
//    @Test
//    public void saveBuyer()throws Exception {
//        BuyerInfoDTO buyerInfo=new BuyerInfoDTO();
//        buyerInfo.setBuyerId("qwerty");
//        buyerInfo.setBuyerName("Tom");
//        buyerInfo.setPassWord("123456");
//        buyerInfo.setBuyerOpenid("888888888");
//        buyerInfo.setCreateTime(new Date());
//        buyerInfo.setUpdateTime(new Date());
//        BuyerInfoDTO result=buyerInfoService.createBuyer(buyerInfo);
//        Assert.assertNotNull(result);
//    }
//}