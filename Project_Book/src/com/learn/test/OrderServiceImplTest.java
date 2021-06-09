package com.learn.test;

import com.learn.pojo.Cart;
import com.learn.pojo.CartItem;
import com.learn.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class OrderServiceImplTest {
    OrderServiceImpl orderService = new OrderServiceImpl();


    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "论坚持", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(1, "论坚持", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(2, "论努力", 1, new BigDecimal(40), new BigDecimal(40)));

        System.out.println("订单号为："+orderService.createOrder(cart, 1));


    }


    @Test
    public void test2() {

    }



}