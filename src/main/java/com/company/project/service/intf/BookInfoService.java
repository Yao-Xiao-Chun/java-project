package com.company.project.service.intf;

import com.company.project.model.entity.BookDocument;

import java.io.IOException;
import java.util.Map;

public interface BookInfoService {

    Map<String,Object> createBookData(BookDocument bookDocument);


    String getBookData(String name) throws IOException;
}
