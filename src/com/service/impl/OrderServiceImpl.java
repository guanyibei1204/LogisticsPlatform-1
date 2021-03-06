package com.service.impl;

import com.dao.OrderDao;
import com.model.Order;
import com.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public boolean insertOrder(Order order) {
        order.setCreateTime(System.currentTimeMillis());
        return orderDao.insertOrder(order) > 0;
    }

    @Override
    public boolean updateOrder(int id, int status) {
        return orderDao.updateOrder(id, status) > 0;
    }

    @Override
    public boolean updateOrderById(int id) {
        return orderDao.updateOrderById(id) > 0;
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id) > 0;
    }

    @Override
    public List<Map<String, Object>> getOrder(int status, int page) {
        return orderDao.getOrder(status, (page - 1) * 7);
    }

    @Override
    public List<Map<String, Object>> selectOrder(int page) {
        return orderDao.selectOrder((page - 1) * 7);
    }

    @Override
    public List<Map<String, Object>> getOrderInfoByCarId(int carId, int status) {
        if (status == Order.STATUS_WAIT_CHECK || status == Order.STATUS_NO_APPLY) {
            return orderDao.selectCarApplyOrderInfo(carId);
        } else {
            return orderDao.selectOrderInfoByCarId(carId, status);
        }
    }

    @Override
    public List<Map<String, Object>> getOrderInfoByOwnerId(int ownerId, int status) {
        return orderDao.selectOrderInfoByOwnerId(ownerId, status);
    }

    @Override
    public Map<String, Object> getCarInfoForOrder(int orderId) {
        return orderDao.selectCarInfoForOrder(orderId);
    }
}
