package com.learn.dao;

import com.learn.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * 类描述：订单 Dao
 *
 * @author
 * @create
 */
public interface OrderDao {

    //添加订单到数据库中
    public int saveOrder(Order order);

    //查询所有订单
    public List<Order> queryOrders();

    //修改订单发货状态
    public int changeOrderStatus(String orderId, int status);

    public List<Order> queryUserOrders(Integer user_id);
}
