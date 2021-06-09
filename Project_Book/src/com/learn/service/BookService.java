package com.learn.service;

import com.learn.pojo.Book;
import com.learn.pojo.Page;

import java.util.List;

/**
 * 类描述：BookService模块接口规范
 *
 * @author
 * @create
 */
public interface BookService {
    //添加图书
    public void addBook(Book book);

    //删除图书
    public void deleteBookById(Integer id);

    //更新图书内容
    public void updateBook(Book book);

    //根据图书id查询一条图书数据
    public Book queryBookById(Integer id);

    //返回多条数据
    public List<Book> queryBooks();

    //返回查询page对象
    public Page page(int pageNo, int pageSize);

    //返回价格区间查找的对象。
    public Page pageByPrice(int pageNo, int pageSize, int min, int max);

}
