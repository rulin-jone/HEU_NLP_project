/**
 * UserService的实现类
 * 实现如下两个方法，其中findAll在JpaRepository中有，findById符合命名规则，都不需专门实现，只需调用即可。
 */
package com.example.mysql.service;

import com.example.mysql.dao.UserDao;
import com.example.mysql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(){
        return userDao.findAll();
    }
    @Override
    public User findById(String id){
        return userDao.findById(id);
    }
}
