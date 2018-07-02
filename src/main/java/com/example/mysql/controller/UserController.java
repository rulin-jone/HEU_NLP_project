/**
 * 查询数据库的UserController，根据前端发来的请求，传递给相应的Service
 */
package com.example.mysql.controller;

import com.example.mysql.entity.User;
import com.example.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<User> querAll(){
        return userService.findAll();
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    public User queryById(@PathVariable String id){
        return userService.findById(id);
    }
}
