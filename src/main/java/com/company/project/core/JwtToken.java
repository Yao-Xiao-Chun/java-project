package com.company.project.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.company.project.entity.LoginUser;

public class JwtToken {

    public String getToken(LoginUser loginUser){
        String token="";
        token= JWT.create().withAudience(loginUser.getId().toString())
                .sign(Algorithm.HMAC256(loginUser.getPassword()));
        return token;
    }
}
