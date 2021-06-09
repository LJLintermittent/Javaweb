package com.learn.dao.impl;

import com.learn.dao.UserDao;
import com.learn.pojo.User;

/**
 * 类描述：UserDaoImpl t_user表实体实现类
 *
 * @author
 * @create
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    //通过username查询一条数据（一个user对象）
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM t_user WHERE USERNAME = ?";
        return queryForOne(User.class,sql,username);
    }

    //通过username和password查询一条数据（一个user对象）
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM t_user WHERE USERNAME = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    //向t_user表中插入一条数据。
    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
