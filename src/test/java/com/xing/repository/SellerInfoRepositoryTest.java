package com.xing.repository;

import com.xing.dataobject.SellerInfo;
import com.xing.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUserName("admin");
        sellerInfo.setPassWord("admin");
        sellerInfo.setOpenId("abc");
        sellerInfo.setCreateTime(new Date());
        sellerInfo.setUpdateTime(new Date());
        SellerInfo result=sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenId()throws Exception{
        SellerInfo result=sellerInfoRepository.findByOpenId("abc");
        Assert.assertEquals("abc",result.getOpenId());

    }


}