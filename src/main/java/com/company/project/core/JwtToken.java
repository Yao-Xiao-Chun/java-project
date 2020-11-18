package com.company.project.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.company.project.configurer.WebMvcConfigurer;
import com.company.project.entity.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JwtToken {

    private final Logger logger = LoggerFactory.getLogger(JwtToken.class);
    public String getToken(LoginUser loginUser){


        String token="";
        logger.info(loginUser.getId().toString()+"生成的token数据");
        logger.info(loginUser.getPassword()+"生成token的密码");
        token= JWT.create().withAudience(loginUser.getId().toString())
                .sign(Algorithm.HMAC256(loginUser.getPassword()));
        return token;
    }
}
