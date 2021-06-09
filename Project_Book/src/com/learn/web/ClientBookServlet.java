package com.learn.web;

import com.learn.pojo.Page;
import com.learn.service.BookService;
import com.learn.service.impl.BookServiceImpl;
import com.learn.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //2 调用 BookService.page(pageNo， pageSize)： Page 对象
        Page page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");

        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);

        //4 请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }


    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取请求参数pageNo和pageSize、min最小价格，max最大价格
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);

        //2 调用 BookService.page(pageNo， pageSize)： Page 对象
        Page page = bookService.pageByPrice(pageNo, pageSize,min,max);
        StringBuilder str = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if(request.getParameter("min")!= null){
            str.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max")!= null){
            str.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(str.toString());

        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);

        //4 请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
