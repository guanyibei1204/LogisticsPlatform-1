package com.service.impl;

import com.dao.OrderInfoDao;
import com.model.OrderInfo;
import com.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("OrderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoDao orderInfoDao;

    @Override
    /*根据订单信息填写完整程度，决定是否发布成功*/
    public boolean insertOrderInfo(OrderInfo orderInfo){
        if(null!=orderInfo.getGoods()&&null!=orderInfo.getDeparture()&&null!=orderInfo.getTarget()&&null!=orderInfo.getDeliveryTime()&&null!=orderInfo.getWeight()){
            if(orderInfo.getType()!=-1){
                //订单中插入一条记录
                return orderInfoDao.insertOrderInfo(orderInfo) > 0;
            }
        }
        return false;
    }

    @Override
    public List<Map<String , Object>> getOrderInfo(int page){
        return orderInfoDao.getOrderInfo(page);
    }

    @Override
    public List<Map<String ,Object >> searchOrderInfo(int type, String departure, String target,int page){
        return orderInfoDao.selectOrderInfo(type, departure,  target, page);
    }

}