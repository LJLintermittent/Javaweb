package com.learn.disuse;

import com.learn.pojo.User;
import com.learn.service.UserService;
import com.learn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用userService.login()登录处理业务
        User loginUser = service.login(new User(null, username, password, null));
        //如果loginUser是null的话
        if(loginUser == null){
            //将用户输入的错误信息和输入框的值回传给登录页面。
            request.setAttribute("msg", "用户名或密码输入不正确。");
            request.setAttribute("username", username);
            //登录失败，跳回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            //登录成功，跳转到成功界面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }


    }

}
