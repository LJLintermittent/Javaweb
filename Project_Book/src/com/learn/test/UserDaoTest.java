package com.learn.test;

import com.learn.dao.UserDao;
import com.learn.dao.impl.UserDaoImpl;
import com.learn.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class UserDaoTest {

    //判断用户名
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("maomao"));
//        if(userDao.queryUserByUsername("admin") == null){
//            System.out.println("用户名可用！");
//        }else{
//            System.out.println("用户名已存在！");
//        }

    }

    //判断用户和密码
    @Test
    public void queryUserByUsernameAndPassword() {

        if(userDao.queryUserByUsernameAndPassword("ADMIN","admin") == null){
            System.out.println("用户名或密码输入错误");
        }else{
            System.out.println("验证通过！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"root","root","wzg16@qq.com")));
    }
}