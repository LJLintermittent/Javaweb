package com.learn.test;

import com.learn.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;

/**
 * 类描述：JDBC测试
 *
 * @author
 * @create
 */
public class JDBCUtilsTest {

    public static void main(String[] args) {

    }

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 3; i++) {
            Connection connection = JDBCutils.getConnection();
            System.out.println(connection);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new Thread();

    }
}
