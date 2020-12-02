package com.company.project.service.intf;

import com.company.project.model.entity.BookDocument;

import java.util.Map;

public interface BookInfoService {

    Map<String,Object> createBookData(BookDocument bookDocument);


    void getBookData(String name);
}
