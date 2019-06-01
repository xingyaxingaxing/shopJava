package com.xing.service;

import com.xing.dataobject.BuyerInfo;
import com.xing.dto.BuyerInfoDTO;

public interface BuyerInfoService {
    //创建用户
    BuyerInfoDTO createBuyer(BuyerInfoDTO buyerInfoDTO);
    //BuyerInfoDTO findOne(String buyerId);
    BuyerInfo findBuyerInfoByOpenId(String buyerId);
}
