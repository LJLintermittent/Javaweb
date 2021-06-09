package com.learn.test;

import com.learn.dao.impl.OrderDaoImpl;
import com.learn.utils.JDBCutils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class OrderDaoImplTest {

    @Test
    public void changeOrderStatus() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.changeOrderStatus("15858766431795", 1);
        JDBCutils.commitAndClose();
    }
}