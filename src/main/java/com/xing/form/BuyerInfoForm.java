package com.xing.form;

import org.hibernate.validator.constraints.NotEmpty;

public class BuyerInfoForm {

    @NotEmpty(message = "id不能为空")
    private String buyerId;
    @NotEmpty(message = "姓名不能为空")
    private String buyerName;
    @NotEmpty(message = "密码不能为空")
    private String passWord;
    @Override
    public String toString() {
        return "BuyerInfoForm{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
