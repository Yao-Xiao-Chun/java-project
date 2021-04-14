package com.company.project.service.impl;

import com.company.project.config.JestClientConfig;
import com.company.project.model.entity.BookDocument;
import com.company.project.service.intf.BookInfoService;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookInfoServiceImpl  implements BookInfoService
{
    @Autowired
    private JestClientConfig jestClientConfig;

    @Autowired
    private JestClient jestClient;

    @Override
    public Map<String, Object> createBookData(BookDocument bookDocument)
    {

        Index index = new Index.Builder(bookDocument).index("book").type("qihuan").build();

        Map<String,Object> map = new HashMap<>();

        try{

           DocumentResult documentResult =  jestClientConfig.getJestCline().execute(index);

           map.put("id",documentResult.getId());

           map.put("message","生成成功");


        }catch (IOException ioException){

            map.put("message",ioException.getLocalizedMessage());
        }

        return map;

    }

    @Override
    public String getBookData(String name) throws IOException {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(new MultiMatchQueryBuilder(name, "bookName","bookAuthor","desc"));


      return "";
    }
}
