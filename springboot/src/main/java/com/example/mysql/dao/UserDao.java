/**
 * MySQL中User的DAO，声明对数据库的CRUD，
 * 这里继承了JpaRepository类，几乎可以不用写方法。
 * 非常赞的功能就是，可以根据方法名自动生成SQL，
 * 比如findByUserName会自动产生一个以userName为参数的查询方法，findAll自动查询表中所有数据
 * 在这里，我连接的MySQL中存的是学生的id、name、classid、grade，先定义一个方法——根据id查找学生
 */
package com.example.mysql.dao;

import com.example.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    // 根据ID查找
    public User findById(String id);
}
