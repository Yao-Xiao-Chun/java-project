package com.company.project.mapper.two;

import com.company.project.model.entity.Area;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AreaMapper {
    @Select("select area_name from bbc_area where area_id = 1")
    String getArea();

    @Select("select * from bbc_area")
    Page<Area> areaList();
}
