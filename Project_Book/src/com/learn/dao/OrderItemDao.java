package com.learn.dao;

import com.learn.pojo.OrderItem;

import java.util.List;

/**
 * 类描述：OrderItem订单项Dao
 *
 * @author
 * @create
 */
public interface OrderItemDao  {
    //保存订单细项
    public int saveOrderItem(OrderItem orderItem);

    //查询订单细项
    public  List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
