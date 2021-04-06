package com.company.project.service.intf;

import com.company.project.model.entity.Area;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AreaService {

    String getArea();

    PageInfo<Area> getAreaList();
}
