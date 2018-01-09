package com.dao;

import com.model.Order;

import java.util.List;
import java.util.Map;
//import java.util.Map;

public interface OrderDao {
    /**
     * 发布货物信息
     */
    int insertOrder(Order order);

    /**
     * 更新货物状态
     */
    int updateOrder(int id, int status);

    /**
     * 将货物信息更新为已完成状态
     */
    int updateOrderById( int id );

    /**
     * 删除货物信息
     */
    int deleteOrder(int id);

    /**
     *获取某状态下的货物信息
     */
    List<Map<String,Object>> getOrder(int status, int page);

    /**
     * 获取货物的全部信息
     */
    List<Map<String ,Object >> selectOrder(int page);
}
