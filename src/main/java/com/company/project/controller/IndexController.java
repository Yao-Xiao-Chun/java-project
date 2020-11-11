package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

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

    @RequestMapping("/user_list")
    public String list()
    {
        System.out.println("开始执行查询>>>");

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from users where id =1");

        System.out.println(list.get(0));

        System.out.println("查询1条数据>>>");

        return "hello";
    }

    @RequestMapping("/info")
    public void info()
    {
        System.out.println("开始执行查询>>>");

        try{
            userService.getUserById(1);
            System.out.println("正常结果");
        }catch (Exception exception){

            System.out.println(exception.getMessage());
        }
        return;

    }

    @RequestMapping("/total")
    public Result count()
    {
        Result result = new Result();

        Map<String,Object> map = new HashMap<>();


        try{
            int total = userService.total();
            map.put("total",total);
            map.put("msg","访问成功");
        }catch (Exception exception){
            map.put("msg",exception.getMessage());

        }
        return result.setData(map);

    }
}
