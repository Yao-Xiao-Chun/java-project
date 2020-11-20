package com.company.project.controller;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.UserLoginToken;
import com.company.project.model.entity.FormUser;
import com.company.project.model.entity.User;
import com.company.project.service.intf.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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

    @UserLoginToken
    @RequestMapping("/user_list")
    public Result list()
    {
        System.out.println("开始执行查询>>>");
        Result result = new Result();

        List<User> list = userService.getAll(1,10);

        System.out.println(list);
        System.out.println("查询1条数据>>>");

        return result.setData(list).setMessage("访问成功");
    }

    @RequestMapping("/info")
    public Result info()
    {
        System.out.println("开始执行查询>>>");
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();

        try{
            String name = userService.getUserById(1);
            map.put("name",name);
            map.put("msg","访问成功");

        }catch (Exception exception){
            map.put("msg",exception.getMessage());
            System.out.println(exception.getMessage());
        }
        return result.setData(map).setMessage(map.get("msg").toString());

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

    @RequestMapping(value = "/limit",method = RequestMethod.POST)
    public Result userInfo(@RequestBody FormUser formUser,
                           @RequestParam(name = "page",defaultValue = "1") int page,
                           @RequestParam(name = "size",defaultValue = "10") int size
                           )
    {
        Result result = new Result();

        //获取分页参数
        PageInfo<User> user = userService.getPageAll(formUser.getPage(),formUser.getSize());

        return result.setData(user).setMessage("访问成功").setCode(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/add_user",method = RequestMethod.POST)
    public Result addUser()
    {
        Result result = new Result();


        return result;
    }

}
