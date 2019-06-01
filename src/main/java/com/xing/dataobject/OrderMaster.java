package com.xing.dataobject;

import com.xing.enums.OrderStatusEnum;
import com.xing.enums.PayStatusEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
public class OrderMaster {
    /*订单ID*/
    @Id
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
    private Integer oderStatus= OrderStatusEnum.NEW.getCode();
    /*支付状态,默认0为未支付*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

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
}
