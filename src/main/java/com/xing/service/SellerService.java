package com.xing.service;

import com.xing.dataobject.SellerInfo;

public interface SellerService {
    SellerInfo findSellerInfoByOpenId(String openid);
}
