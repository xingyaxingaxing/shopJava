package com.xing.utils;

import com.xing.enums.CodeEnum;
/*utils工具类*/
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T>enumClass){
        for(T each:enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
