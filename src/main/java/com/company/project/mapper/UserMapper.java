package com.company.project.mapper;

import com.company.project.pojo.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    @Select("select username from users where id = 1")
    String selectUser(Integer id);

    @Select("select id,username,password,nick_name as nickName,sex from users")
    List<User> getAll();

    @Insert("insert into users(name) values(#{name})")
    int insert(@Param("name") String name);

    @Select("select count(*) from users")
    int total();

}
