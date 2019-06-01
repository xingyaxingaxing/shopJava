package com.xing.service;

import com.xing.dataobject.ProductCategory;

import java.util.List;
public interface CategoryService {
        ProductCategory findOne(Integer categoryId);

        List<ProductCategory> findAll();

        List<ProductCategory>findByCategoryTypeIn(List<Integer>categoryTypeList);

        ProductCategory save(ProductCategory productCategory);
}
