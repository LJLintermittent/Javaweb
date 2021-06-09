package com.learn.test;

import com.learn.dao.impl.OrderItemImpl;
import com.learn.pojo.OrderItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class OrderItemImplTest {

    @Test
    public void queryOrderItemsByOrderId() {
        OrderItemImpl orderItem = new OrderItemImpl();
        List<OrderItem> orderItems = orderItem.queryOrderItemsByOrderId("15858991868843");
        for (OrderItem item : orderItems) {
            System.out.println(item);
        }

    }
}