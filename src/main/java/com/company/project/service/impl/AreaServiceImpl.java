package com.company.project.service.impl;

import com.company.project.mapper.two.AreaMapper;
import com.company.project.model.entity.Area;
import com.company.project.service.intf.AreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public String getArea() {
        return areaMapper.getArea();
    }

    @Override
    public PageInfo<Area> getAreaList() {

        PageHelper.startPage(1,10);

        PageInfo<Area> pageInfo  = new PageInfo<>(areaMapper.areaList());
        return pageInfo;
    }
}
