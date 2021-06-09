package com.learn.dao.impl;

import com.learn.utils.JDBCutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 类描述：使用DBUtils操作数据库
 *
 * @author
 * @create
 */
public abstract class BaseDao {

    //我们使用DBUtils中封装好的queryRunner对象来进行CRUD操作。
    private QueryRunner queryRunner = new QueryRunner();

    /*
     * @MethodName: update()方法用来执行:insert\\update\\Delete语句
     * @Return: 如果返回-1，说明执行失败
     * 返回其他表示影响的行数
     **/
    public int update(String sql, Object... args) {
        Connection conn = JDBCutils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /*
     **
     * 查询返回一个 javaBean 的 sql 语句
     * 也就是查询返回一条数据。
     * @param type 返回的对象类型
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCutils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /*
     * 查询返回多个 javaBean 的 sql 语句
     * @param type 返回的对象类型
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection conn = JDBCutils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);

        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    /* 执行返回一行一列的 sql 语句
     * @param sql 执行的 sql 语句
     * @param args sql 对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = JDBCutils.getConnection();
        try {
           return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

}
