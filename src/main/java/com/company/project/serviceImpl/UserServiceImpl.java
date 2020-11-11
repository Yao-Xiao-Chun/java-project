package com.company.project.serviceImpl;

import com.company.project.mapper.UserMapper;
import com.company.project.pojo.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Map<String, Object> getAll(int pageNum, int pageSize) {
        return null;
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
}
