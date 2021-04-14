package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.model.entity.BookDocument;
import com.company.project.model.entity.two.LiteBooks;
import com.company.project.service.intf.BookInfoService;
import com.company.project.service.intf.LiteBookService;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.util.List;
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

    @Autowired
    private LiteBookService liteBookService;


    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public Result createEsData(@RequestBody BookDocument bookDocument)
    {

        Result result = new Result();

        Map<String,Object> map = bookInfoService.createBookData(bookDocument);

        result.setData(map).setMessage("创建成功");

        return result;
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public Result getBookNames()
    {
        Result result = new Result();

        List<Object> name = liteBookService.setLiteBookData();

        result.setData(name);

        return result;
    }


    @GetMapping(value = "/list")
    public Result getBookList() throws IOException {

        Result result = new Result();

        String list = bookInfoService.getBookData("");

        result.setData(list).setMessage("获取输入列表");

        return  result;
    }

}
