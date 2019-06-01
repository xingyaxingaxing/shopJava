package com.xing.form;

import org.hibernate.validator.constraints.NotEmpty;

public class AwaitPaidForm {
    private String createTime;
    private String detailId;
    private String oderId;
    private String oderAmount;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getOderAmount() {
        return oderAmount;
    }

    public void setOderAmount(String oderAmount) {
        this.oderAmount = oderAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "支付未完成")
    private String payStatus;

    @NotEmpty(message = "手机号必填")
    private String buyerPhone;

    @NotEmpty(message = "地址必填")
    private String buyerAddress;
    @NotEmpty(message = "openid必填")
    private String buyerOpenid;

    @Override
    public String toString() {
        return "AwaitPaidForm{" +
                "createTime='" + createTime + '\'' +
                ", detailId='" + detailId + '\'' +
                ", oderId='" + oderId + '\'' +
                ", oderAmount='" + oderAmount + '\'' +
                ", name='" + name + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerOpenid='" + buyerOpenid + '\'' +
                '}';
    }
}
