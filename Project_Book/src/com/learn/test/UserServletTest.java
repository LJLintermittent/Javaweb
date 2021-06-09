package com.learn.test;

import java.lang.reflect.Method;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/6/15 20:17<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class UserServletTest {
    public void login(){
        System.out.println("这是login()被调用了");
    }
    public void regist(){
        System.out.println("这是regist()被调用了");
    }
    public void updateUsername(){
        System.out.println("这是updateUsername()被调用了");
    }
    public void updatePassword(){
        System.out.println("这是updatePassword()被调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
