package com.company.project.controller;

import com.company.project.core.JwtToken;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.entity.LoginUser;
import com.company.project.entity.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

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

        Map<String,Object> map = new HashMap<>();
        try{

            User user = userService.getByOne(1);
            LoginUser loginUser = null;


            loginUser.setId(user.getId());

            loginUser.setPassword(user.getPassword());

            JwtToken jwtToken = new JwtToken();

            String token = jwtToken.getToken(loginUser);
            map.put("token",token);

        }catch (Exception exception){
            map.put("msg",exception.getMessage());
        }





        return result.setData(map).setMessage("生成token成功");

    }

}
