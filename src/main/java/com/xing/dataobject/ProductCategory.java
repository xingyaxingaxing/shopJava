package com.xing.dataobject;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
public class ProductCategory {

    /*類目ID*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /*類目Name*/
    private String categoryNme;
    /*類目Type*/
    private Integer categoryType;
    /*创建时间*/
    private Date createTime;

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

    /*更新时间*/
    private Date updateTime;
    public ProductCategory()
    {

    }
    public  ProductCategory(String categoryNme,Integer categoryType)
    {
        this.categoryNme=categoryNme;
        this.categoryType=categoryType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryNme() {
        return categoryNme;
    }

    public void setCategoryNme(String categoryNme) {
        this.categoryNme = categoryNme;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{"+
                "getCategoryId="+categoryId+
                ", categoryNme='"+categoryNme+'\''+
                ",categoryType="+categoryType+'}';
    }

}
