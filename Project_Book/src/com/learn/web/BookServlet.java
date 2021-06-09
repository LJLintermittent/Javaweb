package com.learn.web;

import com.learn.pojo.Book;
import com.learn.pojo.Page;
import com.learn.service.BookService;
import com.learn.service.impl.BookServiceImpl;
import com.learn.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //2 调用 BookService.page(pageNo， pageSize)： Page 对象
        Page page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);

        //4 请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo += 1;

        //1.获取请求的参数，封装为book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //2.调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3.使用重定向，跳转到图书页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }


    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo += 1;
        //1、获取请求的参数id
        String id = request.getParameter("id");
        //2、调用工具类方法，将String型的id转为int型
        int idValue = WebUtils.parseInt(id, 0);

        //3、调用service层的delete删除方法。
        bookService.deleteBookById(idValue);

        //4、请求重定向，回到展示页面。
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数==封装为BOOk对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //2.调用Bookservice.updateBook(boo k);修改图书
        bookService.updateBook(book);
        //3.修改成功 重定向回到展示页面。
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.调用queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3.保存图书到request域中
        request.setAttribute("book", book);
        //4.请求转发到/pages/manager/book_edit.jsp页面。
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);

    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过BookServlet查询全部图书
        List<Book> books = bookService.queryBooks();

        //2.把全面图书保存到request域中
        request.setAttribute("books", books);

        //3.请求转发到/pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}

