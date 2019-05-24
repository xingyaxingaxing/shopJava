package com.xing.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
/*
 * http请求返回的最外层对象,VO即ObjectView
 * 商品包含类目*
 * */
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private  Integer type;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }
}
