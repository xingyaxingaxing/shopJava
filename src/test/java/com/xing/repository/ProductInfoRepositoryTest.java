package com.xing.repository;

import com.xing.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void saveTest() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234568");
        productInfo.setProductName("hh皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好哈哈哈喝");
        productInfo.setProductIcon("http://..ff...");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        repository.save(productInfo);
    }
    @Test
    public void findByProductStatus()
            throws Exception
    {
        List<ProductInfo>productInfoList=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }

}