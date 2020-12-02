package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.model.entity.BookDocument;
import com.company.project.service.intf.BookInfoService;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 操作es
 */
@RestController
@RequestMapping("/es")
public class BookController {

    @Autowired
    private BookInfoService bookInfoService;



    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public Result createEsData(@RequestBody BookDocument bookDocument)
    {

        Result result = new Result();

        Map<String,Object> map = bookInfoService.createBookData(bookDocument);

        result.setData(map).setMessage("创建成功");

        return result;
    }
}
