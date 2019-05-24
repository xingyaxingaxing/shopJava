package com.xing.repository;

import com.xing.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest()
    {
        ProductCategory productCategory=repository.findOne(1);
        productCategory.setCategoryType(3);
        repository.save(productCategory);

    }
    @Test
    @Transactional
    public void saveTest()
    {
        ProductCategory productCategory=new ProductCategory("男生最愛",3);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(null,result);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer>list= Arrays.asList(2,3,4);
        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}