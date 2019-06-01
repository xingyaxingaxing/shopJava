package com.xing.repository;
import com.xing.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void saveTest(){
      OrderMaster orderMaster=new OrderMaster();
      orderMaster.setOderId("1234567");
      orderMaster.setBuyerNme("师兄");
      orderMaster.setBuyerPhone("123456789123");
      orderMaster.setBuyerAddress("慕课网");
      orderMaster.setBuyerOpenid("110110");
      orderMaster.setOderAmount(new BigDecimal(2.3));
      orderMaster.setCreateTime(new Date());
      OrderMaster result=repository.save(orderMaster);
          Assert.assertNotNull(result);
    }

   // @Test
   // public void findByBuyerOpenid() throws Exception{
   //     PageRequest request=new PageRequest(0,1);
   //     Page<OrderMaster>result =repository.findByBuyerOpenid(OPENID,request);
   //     Assert.assertNotEquals(0,result.getTotalElements());
   // }

}