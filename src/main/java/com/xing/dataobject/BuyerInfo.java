package com.xing.dataobject;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
/*注册信息
 * */
//数据库的映射对象,标记该类是一个JPA实体类
@Entity
//增加与数据库操作相关的速度
public class BuyerInfo {
    @Id
    private String buyerId;

    private String buyerName;

    private String passWord;

    private String buyerOpenid;

    private Date createTime;

    private Date updateTime;

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

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
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
        return "BuyerInfo{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", buyerOpenid='" + buyerOpenid + '\'' +
                '}';
    }
}
