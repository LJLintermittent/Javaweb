package com.learn.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 类描述：数据库连接类
 *
 * @author
 * @create
 */
public class JDBCutils {

    //私有化静态德鲁伊连接池对象
    private static DruidDataSource dataSource;

    //使用ThreadLocal来进行事务的管理
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    //静态代码块中加载
    //为什么要使用静态代码块呢？因为我如果使用方法，我每次都会创建一个新的连接池
    //可以使用类加载机制，使用静态代码块，随着类加载而加载，且只加载一次。
    //我们的连接池也是只加载一次，其余事件都是从连接池中拿连接罢了。
    static {
        try {
            Properties properties = new Properties();
            //通过类加载器classloader读取JDBCproperties属性配置文件
            InputStream inputStream = JDBCutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);

            //创建数据库连接池
            //通过DruidDataSourceFactory工厂类，调用create创建连接池方法
            //这里一定要强转，因为方法返回的是DataSource对象，而不是我们需要的DruidDataSource对象。
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * @MethodName:获取数据库连接池中的连接
     * 如果返回null 说明获取连接失败。
     * 有值就是获取连接成功。
     **/
    public static Connection getConnection() {
        Connection conn = conns.get();

        if(conn == null){
            try {
                conn = dataSource.getConnection();  //从德鲁伊连接池中获取连接
                conns.set(conn);   //保存到ThreadLocal对象中，供后面的JDBC操作使用。
                conn.setAutoCommit(false); //设置数据库为手动管理事务。
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    /**
     * 提交事务， 并关闭释放连接
    */
    public static void commitAndClose(){
        //直接获取conns中的Connection连接，保证获取的时候的连接和关闭/提交的时候的连接是一个。
        Connection conn = conns.get();

        if(conn != null){   // 如果不等于 null， 说明 之前使用过连接， 操作过数据库
            try {
                conn.commit();  //提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.setAutoCommit(true);
                    conn.close();   //关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行 remove 操作，否则就会出错。（ 因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }


    /**
     * 回滚事务， 并关闭释放连接
     */
    public static void rollbackAndClose(){
        //直接获取conns中的Connection连接，保证获取的时候的连接和关闭/提交的时候的连接是一个。
        Connection conn = conns.get();

        if(conn != null){   // 如果不等于 null， 说明 之前使用过连接， 操作过数据库
            try {
                conn.rollback();  //回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.setAutoCommit(true);
                    conn.close();   //关闭连接，释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行 remove 操作，否则就会出错。（ 因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }


}


    /*
     * @MethodName: 关闭数据库连接池
     **/
   /* public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/

