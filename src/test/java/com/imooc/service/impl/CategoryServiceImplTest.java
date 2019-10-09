package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categroyServiceImpl;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categroyServiceImpl.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categroyServiceImpl.findAll();
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categroyServiceImpl.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("谢旸晖",10);
        ProductCategory result = categroyServiceImpl.save(productCategory);
        Assert.assertNotNull(result);
    }
}