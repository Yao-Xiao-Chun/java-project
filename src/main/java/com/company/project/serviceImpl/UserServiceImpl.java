package com.company.project.serviceImpl;

import com.company.project.mapper.UserMapper;
import com.company.project.pojo.User;
import com.company.project.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAll(int pageNum, int pageSize) {

        return userMapper.getAll();
    }

    @Override
    public String getUserById(Integer id) {
        System.out.println(id);
        System.out.println(userMapper.selectUser(id));
        return userMapper.selectUser(id);
    }

    @Override
    public int total()
    {
       return userMapper.total();
    }
    @Override
    public User getByOne()
    {
        return userMapper.getByOne();
    }


    @Override
    public PageInfo<User> getPageAll(int pageNum, int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        PageInfo<User> pageInfo  = new PageInfo<>(userMapper.getPageAll());
        return pageInfo;
    }
}
