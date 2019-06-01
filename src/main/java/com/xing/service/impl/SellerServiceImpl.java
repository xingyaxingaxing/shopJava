package com.xing.service.impl;

import com.xing.dataobject.SellerInfo;
import com.xing.repository.SellerInfoRepository;
import com.xing.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openid){
        return repository.findByOpenId(openid);
    }
}
