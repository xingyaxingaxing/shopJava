package com.imooc.dto;

import javax.persistence.criteria.CriteriaBuilder;

/*购物车
* */
public class CarDTO {
    /*商品ID*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
