package com.xing.converter;
import com.xing.dto.BuyerInfoDTO;
import com.xing.form.BuyerInfoForm;
import com.xing.utils.KeyUtil;

import java.util.Date;
public class BuyerInfoForm2Converter {
    public static BuyerInfoDTO convertBuyer(BuyerInfoForm buyerInfoForm){
        BuyerInfoDTO buyerInfoDTO=new BuyerInfoDTO();
        buyerInfoDTO.setBuyerId(buyerInfoForm.getBuyerId());
        buyerInfoDTO.setPassWord(buyerInfoForm.getPassWord());
        buyerInfoDTO.setBuyerName(buyerInfoForm.getBuyerName());
        return buyerInfoDTO;
    }
}
