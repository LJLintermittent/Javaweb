package com.learn.test;

import com.learn.dao.impl.OrderDaoImpl;
import com.learn.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class OrderDaoTest {
    OrderDaoImpl orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567891", new Date(), new BigDecimal(20), 0, 1));

    }


    @Test
    public void st123() {
        List<Order> orders = orderDao.queryOrders();
        for (Order order : orders) {
            Date createTime = order.getCreateTime();

        }

    }

}