package com.company.project.service.intf;

import com.company.project.model.dto.UserForm;
import com.company.project.model.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


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

   User getByOne(Integer id);

   PageInfo<User> getPageAll(int pageNum, int pageSize);

   List<User> getByIDs(Integer id);

   int insert(UserForm userForm);
}
