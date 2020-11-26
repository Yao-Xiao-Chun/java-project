package com.company.project.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作es
 */
@RestController
@RequestMapping("/es")
public class BookController {

    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public void createEsData()
    {

    }
}
