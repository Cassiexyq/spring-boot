package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Cassie on 2018/4/4.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers(){
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(int id){
        UserEntity user = userMapper.getOne(id);
//        userMapper.findByName()
        return user;
    }

    @RequestMapping("/add")
    public void add(UserEntity user){
         userMapper.insert(user);
    }

    @RequestMapping("/update")
    public void update(UserEntity user){
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id){
        userMapper.delete(id);
    }

}
