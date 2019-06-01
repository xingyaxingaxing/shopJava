package com.xing.service.impl;

import com.xing.dataobject.BuyerInfo;
import com.xing.dto.BuyerInfoDTO;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.repository.BuyerInfoRepository;
import com.xing.service.BuyerInfoService;
import com.xing.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BuyerInfoServiceImpl implements BuyerInfoService {
    @Autowired
    private BuyerInfoService buyerInfoService;
    @Autowired
    private BuyerInfoRepository buyerInfoRepository;

   @Override
   public BuyerInfoDTO createBuyer(BuyerInfoDTO buyerInfoDTO) {
       String buyerOpenid=KeyUtil.genUniqueKey();
       //1查询注册用户
           BuyerInfo buyerInfo=new BuyerInfo();
           BuyerInfo buyerInfo1 = buyerInfoRepository.findOne(buyerInfoDTO.getBuyerId());
           if (buyerInfo1 != null) {
               throw new SellException(ResultEnum.USER_EXITS);
           }
           buyerInfo.setBuyerOpenid(buyerOpenid);
           buyerInfo.setCreateTime(new Date());
           buyerInfo.setUpdateTime(new Date());
           buyerInfo.setBuyerId(buyerInfoDTO.getBuyerId());
           buyerInfo.setBuyerName(buyerInfoDTO.getBuyerName());
           buyerInfo.setPassWord(buyerInfoDTO.getPassWord());
           buyerInfoRepository.save(buyerInfo);

       return buyerInfoDTO;
   }
   //@Override
   //@Transactional
   //public BuyerInfoDTO findOne(String buyerId) {
   //    BuyerInfo buyerInfo=buyerInfoRepository.findOne(buyerId);
   //    if(buyerId==null){
   //        throw new SellException(ResultEnum.USER_NOT_EXITS);
   //    }
   //    List<BuyerInfo>buyerInfos=buyerInfoRepository.findByBuyerId(buyerId);
   //    if(CollectionUtils.isEmpty((buyerInfos))){
   //        throw new SellException(ResultEnum.USER_NOT_EXITS);
   //    }
   //    BuyerInfoDTO buyerInfoDTO=new BuyerInfoDTO();
   //    BeanUtils.copyProperties(buyerInfo,buyerInfoDTO);
   //    buyerInfoDTO.setBuyerInfosList(buyerInfos);
   //    return buyerInfoDTO;
   //}

    @Override
    public BuyerInfo findBuyerInfoByOpenId(String buyerId) {
            return buyerInfoRepository.findByBuyerId(buyerId);
    }
}
