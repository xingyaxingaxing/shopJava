package com.xing.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xing.dataobject.OderDetail;
import com.xing.enums.OrderStatusEnum;
import com.xing.enums.PayStatusEnum;
import com.xing.utils.EnumUtil;
import com.xing.utils.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*订单ID*/
    private String oderId;
    /*买家名字*/
    private String buyerNme;
    /*买家手机号*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家Openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal oderAmount;
    /*订单状态,默认0为新下单*/
    private Integer oderStatus;
    /*支付状态,默认0为未支付*/
    private Integer payStatus;

    /*订单状态,默认0为新下单*/
   // private String oderStatusStr;
    /*支付状态,默认0为未支付*/
   // private String payStatusStr;

    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(oderStatus,OrderStatusEnum.class);
        //this.oderStatusStr = EnumUtil.getByCode(oderStatus,OrderStatusEnum.class).getMessage();
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
        // this.payStatusStr = EnumUtil.getByCode(payStatus,PayStatusEnum.class).getMessage();
    }
   // @JsonIgnore
   // public void getOrderStatusEnum(){
   //
   //    //this.oderStatusStr = EnumUtil.getByCode(oderStatus,OrderStatusEnum.class).getMessage();
   // }
//
   // @JsonIgnore
   // public void getPayStatusEnum(){
   //    // this.payStatusStr = EnumUtil.getByCode(payStatus,PayStatusEnum.class).getMessage();
   // }

    public List<OderDetail> getOderDetailList() {
        return oderDetailList;
    }

    public void setOderDetailList(List<OderDetail> oderDetailList) {
        this.oderDetailList = oderDetailList;
    }

    List<OderDetail>oderDetailList;

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public String getBuyerNme() {
        return buyerNme;
    }

    public void setBuyerNme(String buyerNme) {
        this.buyerNme = buyerNme;
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

    public BigDecimal getOderAmount() {
        return oderAmount;
    }

    public void setOderAmount(BigDecimal oderAmount) {
        this.oderAmount = oderAmount;
    }

    public Integer getOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(Integer oderStatus) {
        this.oderStatus = oderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

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
    @Override
    public String toString() {
        return "OrderMaster{"+
                "oderId="+oderId+
                ", buyerNme='"+buyerNme+'\''+
                ", buyerPhone='"+buyerPhone+'\''+
                ", buyerAddress='"+buyerAddress+'\''+
                ", buyerOpenid='"+buyerOpenid+'\''+
                ", oderAmount='"+oderAmount+'\''+
                ", oderStatus='"+oderStatus+'\''+
                ", payStatus='"+payStatus+'\''+
                ", createTime='"+createTime+'\''+
                ",updateTime="+updateTime+'}';
    }

   //public String getOderStatusStr() {
   //    return oderStatusStr;
   //}

   //public void setOderStatusStr(String oderStatusStr) {
   //    this.oderStatusStr = oderStatusStr;
   //}

   //public String getPayStatusStr() {
   //    return payStatusStr;
   //}

   //public void setPayStatusStr(String payStatusStr) {
   //    this.payStatusStr = payStatusStr;
   //}
}
