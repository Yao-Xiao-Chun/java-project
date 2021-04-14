package com.company.project.service.impl;

import com.company.project.mapper.two.LiteBooksMapper;
import com.company.project.model.entity.BookDocument;
import com.company.project.model.entity.two.LiteBooks;
import com.company.project.service.intf.BookInfoService;
import com.company.project.service.intf.LiteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LiteBookServiceImpl implements LiteBookService {

    @Autowired
    private LiteBooksMapper liteBooksMapper;

    @Autowired
    private BookInfoService bookInfoService;

    @Override
    public List<LiteBooks> getLiteBookName()
    {

       return liteBooksMapper.getBookName();//获取

    }

    @Override
    public List<Object> setLiteBookData() {

        //查询liteBookName列表
        List<LiteBooks> liteBooks = liteBooksMapper.getBookName();

        List<Object> list = new ArrayList<>();

        for(int i = 0; i < liteBooks.size(); i++){

            LiteBooks liteBooks1 = liteBooks.get(i);

            //拼接数据
            BookDocument bookDocument = new BookDocument();

            bookDocument.setBookName(liteBooks1.name);//设置文章名称

            bookDocument.setBookAuthor("未知");

            bookDocument.setBookId(liteBooks1.id);

            bookDocument.setCreatedAt(liteBooks1.created_at);

            bookDocument.setUpdatedAt(liteBooks1.updated_at);

            bookDocument.setDeletedAt(liteBooks1.deleted_at);

            bookDocument.setImage(liteBooks1.image);

            bookDocument.setUrl(liteBooks1.url);

            bookDocument.setPages(1);

            //写入es

            Map<String,Object> map = bookInfoService.createBookData(bookDocument);

            list.add(map);

        }


        return list;
    }


}
