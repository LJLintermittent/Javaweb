package com.learn.test;

import com.learn.pojo.User;
import com.learn.service.UserService;
import com.learn.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类描述：UserService实体类测试
 *
 * @author
 * @create
 */
public class UserServiceTest {
    private UserService service = new UserServiceImpl();

    @Test
    public void registUser() {
        service.registUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(service.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existsUsername() {
        if (service.existsUsername("admin") == false){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }
}