package com.learn.test;

import com.learn.pojo.Book;
import com.learn.service.BookService;
import com.learn.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 类描述：
 *
 * @author
 * @create
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "守望先锋1", "暴雪", new BigDecimal(168), 2000, 800, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(25, "守望先锋2", "暴雪", new BigDecimal(20), 500, 800, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}