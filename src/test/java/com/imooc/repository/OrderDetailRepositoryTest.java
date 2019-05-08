package com.imooc.repository;

import com.imooc.dataobject.OderDetail;
import org.apache.catalina.LifecycleState;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    private final String OPENID="110110";
    @Test
    public void saveTest(){
        OderDetail orderDetail=new OderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOderId("11111113");
        orderDetail.setProductIcon("http//xxxx.jpg");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("鸡翅");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(5);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());

        OderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void  findByOderId()throws Exception{
        List<OderDetail> orderDetailList=repository.findByOderId("11111111");
        Assert.assertNotEquals(0,orderDetailList.size());

    }
    @Test
    public void fingByOredrIdIn() throws Exception{
        List<String>orderIdList= Arrays.asList("11111111","11111112");

    }

}