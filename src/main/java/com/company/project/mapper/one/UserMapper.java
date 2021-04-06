package com.company.project.mapper.one;

import com.company.project.model.dto.UserForm;
import com.company.project.model.entity.User;

import com.github.pagehelper.Page;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select password from users where id = 1")
    String selectUser(Integer id);

    @Select("select id,username,password,nick_name,sex from users")
    List<User> getAll();

    @Insert("insert into users(username,password,nick_name,sex) values(#{username},#{password},#{nickName},#{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")//新增后获取主键id
    int insert(UserForm name);

    @Select("select count(*) from users")
    int total();

    @Select("select * from users where id = #{id}")
    @Results({

    })
    User getByOne(Integer id);

    @Select("select * from users")
    @Results({

    })
    Page<User> getPageAll();

    //@Select("select * from users")
    @Select("select id,username,password,nick_name,sex from users where id=#{id}")
    List<User> getByIDs(Integer id);
}
