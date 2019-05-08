package com.imooc.dataobject;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
//数据库的映射对象
@Entity
@DynamicUpdate
public class OderDetail {
    @Id
    private String detailId;
    /*订单Id*/
    private String oderId;
    /*商品ID*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*商品单价*/
    private BigDecimal productPrice;
    /*商品数量*/
    private Integer productQuantity;
    /*商品小图*/
    private String productIcon;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
    @Override
    public String toString() {
        return "OrderDetail{"+
                "detailId="+detailId+
                ", oderId='"+oderId+'\''+
                ", productId='"+productId+'\''+
                ", productName='"+productName+'\''+
                ", productPrice='"+productPrice+'\''+
                ", productQuantity='"+productQuantity+'\''+
                ",productIcon="+productIcon+'}';
    }
}
