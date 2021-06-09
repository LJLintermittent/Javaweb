package com.learn.test;

import com.learn.dao.BookDao;
import com.learn.dao.impl.BookDaoImpl;
import com.learn.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 类描述：BookDao实现类测试
 *
 * @author
 * @create
 */
public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"战地五", "未知",new BigDecimal(999),200,50, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"战地五", "V社",new BigDecimal(999),200,50, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

}