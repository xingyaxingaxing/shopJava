package com.imooc.form;

import java.util.Date;

public class CategoryForm {
    private Integer categoryId;

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

    /*類目Name*/
    private String categoryNme;
    /*類目Type*/
    private Integer categoryType;

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

    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
}
