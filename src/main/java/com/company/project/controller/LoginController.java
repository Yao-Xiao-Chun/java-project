package com.company.project.controller;

import com.company.project.core.JwtToken;
import com.company.project.core.Result;
import com.company.project.model.entity.LoginUser;
import com.company.project.model.entity.User;
import com.company.project.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/dologin",method = RequestMethod.GET)
    public Result doLogin()
    {
        //生成token
        Result result = new Result();
        User user = userService.getByOne(1);
        Map<String,Object> map = new HashMap<>();

        LoginUser loginUser = new LoginUser();
        loginUser.setId(user.getId().intValue());
        loginUser.setPassword(user.getPassword());

        JwtToken jwtToken = new JwtToken();

        String token = jwtToken.getToken(loginUser);
        map.put("token",token);
        map.put("info",user);

        return result.setData(map).setMessage("生成token成功");

    }

}
