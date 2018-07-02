/**
 * 操作数据库中user表的Service
 * 声明方法，在实现类中实现即可
 */
package com.example.mysql.service;

import com.example.mysql.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(String id);
}
