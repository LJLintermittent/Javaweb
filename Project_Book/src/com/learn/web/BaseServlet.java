package com.learn.web;

import com.learn.service.UserService;
import com.learn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 类描述：公用Servlet方法抽取，让实际的业务子类进行继承
 *
 * @author
 * @create
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据流之前，设置编码为utf-8
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码的问题。
        response.setContentType("text/html; charset=UTF-8");
        //获取隐藏域中的数据，根据因隐藏域返回的值判断调用登录还是注册。
        String actionValue = request.getParameter("action");

        /*旧版写法，代码冗余出现大量if else
        if ("login".equalsIgnoreCase(actionValue)){
            Login(request, response);
        }else if ("regist".equalsIgnoreCase(actionValue)){
            Regist(request, response);
        }*/

        //通过反射，获取对应名称的方法。然后执行。
        try {
            Method method = this.getClass().getDeclaredMethod(actionValue, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(); // 把异常抛给 Filter 过滤器
        }
    }
}

