package com.learn.test;

import com.learn.pojo.Cart;
import com.learn.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "史诗", 1, new BigDecimal(300), new BigDecimal(300)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "史诗", 1, new BigDecimal(300), new BigDecimal(300)));

        cart.deleteItem(2);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "史诗", 1, new BigDecimal(300), new BigDecimal(300)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "史诗", 1, new BigDecimal(300), new BigDecimal(300)));

        cart.clear();
        cart.addItem(new CartItem(1, "神话", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.updateCount(1, 5);

        System.out.println(cart);
    }

    @Test
    public void tes() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);
    }

}