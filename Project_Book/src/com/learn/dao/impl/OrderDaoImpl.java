package com.learn.dao.impl;

import com.learn.dao.OrderDao;
import com.learn.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * 类描述：订单Dao实现类
 *
 * @author
 * @create
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {


    /**
      * @MethodName: 保存订单信息
      * @Return:
     **/
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES(?,?,?,?,?)";
       return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    /**
     * @MethodName: 查询所有订单
     * @param: []
     * @Return: java.util.List<com.learn.pojo.Order>
    **/
    @Override
    public List<Order> queryOrders() {
        String sql = "SELECT `order_id` AS `orderId`,`create_time`AS `createTime`" +
                ",`price` AS `price`,`status` AS `status`,`user_id`  AS `userId` FROM t_order ";
        return  queryForList(Order.class, sql);
    }

    /**
     * @MethodName: 修改订单信息
     * @param: [orderId, Status]
     * @Return: int
    **/
    @Override
    public int changeOrderStatus(String orderId, int status) {
        String sql ="UPDATE t_order SET `status`  = ? WHERE `order_id` = ?";
        return  update(sql, status,orderId);
    }

    /**
     * @MethodName: 查询指定用户的订单方法
     * @param: [user_id]
     * @Return: java.util.List<com.learn.pojo.Order>
    **/
    @Override
    public List<Order> queryUserOrders(Integer user_id) {
        String sql = "SELECT `order_id` AS `orderId`,`create_time`AS `createTime`" +
                ",`price` AS `price`,`status` AS `status`,`user_id`  AS `userId` FROM t_order WHERE `user_id` = ? ";
        return  queryForList(Order.class, sql,user_id);
    }
}
