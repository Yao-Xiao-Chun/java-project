package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * api接口返回多种类型数据
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public static Result index(){
        Result result = new Result();

        result.setCode(ResultCode.SUCCESS).setMessage("访问成功");
        Map<String, Object> map = new HashMap<>(3);
        map.put("author","哈哈哈哈");
        map.put("address", "http://blog.itcodai.com");
        map.put("csdn_address", "http://blog.csdn.net/eson_15");
        map.put("fans_num", 4153);
        List<String> list = new ArrayList<>();
        list.add("王大锤");
        list.add("小荷才露尖尖角");
        list.add("早有蜻蜓立上头");
        list.add("面对疾风吧!");
        List<Map> listMap = new ArrayList<>();
        Map<String,String> orderMap = new HashMap<>();

        orderMap.put("order_id","1");
        orderMap.put("order_name","从厕所商品2");
        listMap.add(orderMap);

        map.put("list",list);
        map.put("map_info",listMap);
        result.setData(map);
        return result;
    }
}
