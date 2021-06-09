package com.learn.test;

import com.learn.dao.impl.OrderItemImpl;
import com.learn.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemImpl orderItem = new OrderItemImpl();
        orderItem.saveOrderItem(new OrderItem(null, "java从入门到精通", 1, new BigDecimal(20), new BigDecimal(20), "1234567891"));
        orderItem.saveOrderItem(new OrderItem(null, "javaScript从入门到精通", 2, new BigDecimal(100), new BigDecimal(200), "1234567891"));
        orderItem.saveOrderItem(new OrderItem(null, "Netty入门", 1, new BigDecimal(50), new BigDecimal(50), "1234567891"));

    }
}