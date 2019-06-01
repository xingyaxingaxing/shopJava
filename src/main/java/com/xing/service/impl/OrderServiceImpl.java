package com.xing.service.impl;

import com.xing.controller.WebSocket;
import com.xing.converter.OrderMaster2OrderDTOConverter;
import com.xing.dataobject.OderDetail;
import com.xing.dataobject.OrderMaster;
import com.xing.dataobject.ProductInfo;
import com.xing.dto.CarDTO;
import com.xing.dto.OrderDTO;
import com.xing.enums.OrderStatusEnum;
import com.xing.enums.PayStatusEnum;
import com.xing.exception.ResultEnum;
import com.xing.exception.SellException;
import com.xing.repository.OrderDetailRepository;
import com.xing.repository.OrderMasterRepository;
import com.xing.service.OrderService;
import com.xing.service.ProductService;
import com.xing.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private WebSocket webSocket;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //KeyUtil.genUniqueKey()生成唯一的随机数
        String orderId=KeyUtil.genUniqueKey();
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);

       //// List<CarDTO> carDTOList=new ArrayList<>();
        //1查询商品
        for(OderDetail oderDetail:orderDTO.getOderDetailList()){
            ProductInfo productInfo=productService.findOne(oderDetail.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2计算订单总价(必须用特有的方法)
            orderAmount=productInfo.getProductPrice().
                    multiply(new BigDecimal(oderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            oderDetail.setDetailId(KeyUtil.genUniqueKey());
            oderDetail.setOderId(orderId);
            oderDetail.setCreateTime(new Date());
            oderDetail.setUpdateTime(new Date());
            BeanUtils.copyProperties(productInfo,oderDetail);//Spring提供的对象拷贝属性
            orderDetailRepository.save(oderDetail);

           ////CarDTO carDTO=new CarDTO(oderDetail.getProductId(),oderDetail.getProductQuantity());
           ////carDTOList.add(carDTO);

        }
        //3写入订单数据库
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOderAmount(orderAmount);
        orderMaster.setOderStatus(OrderStatusEnum.NEW.getCode());
        //状态
        //orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterRepository.save(orderMaster);
        //4扣库存
        List<CarDTO> carDTOList=orderDTO.getOderDetailList().stream().map(e->
                new CarDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(carDTOList);
        //发送webSocket消息
        webSocket.sendMessage(orderDTO.getOderId());
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        if(orderMaster==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OderDetail>oderDetailList=orderDetailRepository.findByOderId(orderId);
        if(CollectionUtils.isEmpty((oderDetailList))){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOderDetailList(oderDetailList);
        return orderDTO;
    }

    @Override
    public OrderMaster AfindOne(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        return orderMaster;
    }

    //事务管理对于企业应用来说是至关重要的，即使出现异常情况，它也可以保证数据的一致性。
    @Override
    @Transactional
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster>orderMasterPage=orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);

        List<OrderDTO>orderDTOList=OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        Page<OrderDTO>orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster=new OrderMaster();
        //判断订单状态
        if(!orderDTO.getOderStatus().equals(OrderStatusEnum.NEW.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterRepository.save(orderMaster);
        if(updateResult==null){
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返回库存
        if(CollectionUtils.isEmpty(orderDTO.getOderDetailList())){
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CarDTO> carDTOList=orderDTO.getOderDetailList().stream()
                .map(e->new CarDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(carDTOList);

        //如果已支付，需要退款
        if(orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO
        }

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOderStatus().equals(OrderStatusEnum.NEW.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOderStatus((OrderStatusEnum.FINISHED.getCode()));
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster upateResult=orderMasterRepository.save(orderMaster);
        if(upateResult==null){
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOderStatus().equals(OrderStatusEnum.NEW.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if(!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            throw new SellException(ResultEnum.ORDER_PY_STATUS_ERROR);
        }

        //修改支付状态
        orderDTO.setPayStatus((PayStatusEnum.SUCCESS.getCode()));
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster upateResult=orderMasterRepository.save(orderMaster);
        if(upateResult==null){
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster>orderMasterPage=orderMasterRepository.findAll(pageable);
        List<OrderDTO>orderDTOList=OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<>(orderDTOList,pageable,orderMasterPage.getTotalElements());

    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }
}
