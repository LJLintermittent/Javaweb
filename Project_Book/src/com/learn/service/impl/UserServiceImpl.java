package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.dao.impl.UserDaoImpl;
import com.learn.pojo.User;
import com.learn.service.UserService;

/**
 * 类描述：UserServiceImpl 实现类
 * @create
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    //注册成功后，调用此方法将用户信息保存在库中
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    //用户登录，通过用户名和密码进行查询，返回查询到的对象。
    @Override
    public User login(User user) {
        return  userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    //通过用户名进行查询，如果有返回值，说明已经有这个用户名了
    // 如果没有返回值，说明这个用户名可用。
    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
