package com.company.project.service;

import com.company.project.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> getAll(int pageNum, int pageSize);


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

   User getByOne();

   PageInfo<User> getPageAll(int pageNum, int pageSize);
}
