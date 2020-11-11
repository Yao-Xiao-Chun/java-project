package com.company.project.mapper;

import com.company.project.pojo.User;

import com.github.pagehelper.Page;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    @Select("select id,username,password,nick_name as nickName,sex from users limit 1")
    User getByOne();

    @Select("select * from users")
    @Results({
            @Result(property = "nickName",column = "nick_name")
    })
    Page<User> getPageAll();

}
