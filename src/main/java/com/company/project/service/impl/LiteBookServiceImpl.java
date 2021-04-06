package com.company.project.service.impl;

import com.company.project.mapper.two.LiteBooksMapper;
import com.company.project.service.intf.LiteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiteBookServiceImpl implements LiteBookService {

    @Autowired
    private LiteBooksMapper liteBooksMapper;

    @Override
    public String getLiteBookName()
    {

        System.out.print("names:");
       return liteBooksMapper.getBookName();//获取

    }
}
