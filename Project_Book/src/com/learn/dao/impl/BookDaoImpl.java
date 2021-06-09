package com.learn.dao.impl;

import com.learn.dao.BookDao;
import com.learn.pojo.Book;

import java.util.List;

/**
 * 类描述：BookDao接口具体实现类
 *
 * @author
 * @create
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book( `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath());
    }


    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE t_book SET `NAME`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? WHERE `id` = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
                book.getImgPath(), book.getId());
    }


    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM t_book WHERE id = ?";
        return update(sql, id);
    }



    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` FROM t_book WHERE id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` FROM t_book";
        return queryForList(Book.class, sql);
    }

    /**
     * @MethodName: 获取总记录数
     * @param: [无]
     * @Return: java.lang.Integer
    **/
    @Override
    public Integer queryPageTotalCount() {
        String sql = "SELECT COUNT(*) FROM t_book";
        //强转
        //Number是int的总类
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();

    }

    /**
     * @MethodName: 获取分页位置的Book对象数组
     * @param: [begin, pageSize]
     * @Return: java.util.List<com.learn.pojo.Book>
    **/
    @Override
    public List<Book> queryForPageItems(Integer begin, int pageSize) {
        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` FROM t_book LIMIT ? ,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

     /*
      * @MethodName: 求价格区间的数据总记录数。
      * @Return:
     **/
    @Override
    public Integer queryPageTotalCountByPrice(int min, int max) {
        String sql = "SELECT count(*) FROM t_book WHERE price BETWEEN  ? AND ? ";
        Number byPriceCount =(Number)queryForSingleValue(sql, min, max);
        return byPriceCount.intValue();
    }

    /*
     * @MethodName: 求价格区间的数据对象数组。
     * @Return:
     **/
    @Override
    public List<Book> queryForPageItemsByPrice(int min, int max, Integer begin, int pageSize) {

        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`  FROM t_book WHERE price BETWEEN  ? AND ? order by price LIMIT ?,?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);

    }


}
