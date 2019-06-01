package com.xing.dto;
/*注册信息
 *数据传输对象，在各个层里传输用
 * */
public class BuyerInfoDTO {
    private String buyerId;

    private String buyerName;

    private String passWord;

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
    @Override
    public String toString() {
        return "BuyerInfoDTO{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
