package com.learn.disuse;

import com.learn.dao.UserDao;
import com.learn.dao.impl.UserDaoImpl;
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
public class RegistServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //判断验证码是否正确
        if("abcde".equalsIgnoreCase(code)){

            //判断数据库中是否已存在相同的用户名
            if(service.existsUsername(username)){
                System.out.println("用户名已存在。");

                //用户名已存在的情况，回传数据和错误消息
                request.setAttribute("msg", "用户名已存在。");
                //将用户输入的输入框的值回传给注册页面
                request.setAttribute("username",username);
                request.setAttribute("email",email);

                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

            }else{
                //如果不存在相同用户名则添加数据,并跳转到注册成功页面
                service.registUser(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else{
            //验证码错误跳回注册页面。
            System.out.println("验证码[" + code + "]错误");
            //将用户输入的输入框的值回传给注册页面
            request.setAttribute("username",username);
            request.setAttribute("email",email);

            //跳回注册页面。
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }

    }


}
