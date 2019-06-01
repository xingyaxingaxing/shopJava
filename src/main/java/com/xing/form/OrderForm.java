package com.xing.form;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "支付未完成")
    private String payStatus;

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

    @Override
    public String toString() {
        return "OrderForm{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", openid='" + openid + '\'' +
                ", items='" + items + '\'' +
                ", payStatus='" + payStatus + '\'' +
                '}';
    }
}
