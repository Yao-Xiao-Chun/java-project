package com.company.project.mapper.two;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LiteBooksMapper {

    @Select("select name from lite_books limit 1")
    String getBookName();
}
