package com.learn.dao.impl;

import com.learn.dao.OrderItemDao;
import com.learn.pojo.OrderItem;

import java.util.List;

/**
 * 类描述：OrderItem订单项实现类
 *
 * @author
 * @create
 */
public class OrderItemImpl extends BaseDao implements OrderItemDao {
    //添加订单项
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql ="INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) VALUES(?,?,?,?,?)";
        return  update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    //查询订单详情数据
    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "SELECT `id` AS `id` ,`name` AS `name`,`count` AS `count`,`price` AS `price`,`total_price`  AS `totalPrice`,`order_id` AS `orderId` FROM t_order_item WHERE order_id = ?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
