package com.xing.repository;

import com.xing.dataobject.BuyerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerInfoRepository extends JpaRepository<BuyerInfo,String> {
    BuyerInfo findByBuyerId(String buyerId);
}
