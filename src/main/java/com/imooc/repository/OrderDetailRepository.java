package com.imooc.repository;

import com.imooc.dataobject.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//通过继承Jpa就可以操作数据库，调用该方法的对象就能操作数据库了
public interface OrderDetailRepository extends JpaRepository<OderDetail,String> {
    //方法名对应起来的，调用findByOderId就是查找到orderId
    List<OderDetail>findByOderId(String orderId);
}
