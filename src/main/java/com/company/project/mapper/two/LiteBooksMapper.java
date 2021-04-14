package com.company.project.mapper.two;

import com.company.project.model.entity.two.LiteBooks;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LiteBooksMapper {

    @Select("select * from lite_books")
    List<LiteBooks> getBookName();
}
