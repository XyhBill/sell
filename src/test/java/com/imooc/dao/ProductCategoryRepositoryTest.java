package com.imooc.dao;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory =  repository.findOne(1);
        System.out.println(productCategory.toString());
        System.out.println(productCategory.getCategoryType());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory result = repository.save(productCategory);
        // Assert为断言类，以下方法分别为判断是否对象为空
        Assert.assertNotNull(result);
        // 这个方法的两个参数第一个是不希望数据内容，第二个是希望数据内容，也是一个判断对象的方法，为了简便还是选择第一个
        // Assert.assertEquals(null,result);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result);
    }
}