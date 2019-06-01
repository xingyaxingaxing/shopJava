package com.xing.form;

import org.hibernate.validator.constraints.NotEmpty;

public class BuyerLodinForm {
    @NotEmpty(message = "id不能为空")
    private String buyerId;
    @NotEmpty(message = "密码不能为空")
    private String passWord;

    @Override
    public String toString() {
        return "BuyerLodinForm{" +
                "buyerId='" + buyerId + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
