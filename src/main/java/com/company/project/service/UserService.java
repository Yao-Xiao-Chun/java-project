package com.company.project.service;

import com.company.project.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserService {

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String,Object> getAll(int pageNum, int pageSize);


    /**
     * 根据用户id进行查询
     * @param id
     * @return
     */
   String getUserById(Integer id);

    /**
     *
     * @return
     */
   int total();
}
