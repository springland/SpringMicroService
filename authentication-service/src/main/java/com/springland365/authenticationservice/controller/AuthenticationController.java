package com.springland365.authenticationservice.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    @RequestMapping(value="/user" ,  produces =   {"application/json"})
    public Map<String , Object> user(OAuth2Authentication user)
    {
        Map<String , Object> userInfo = new HashMap<>();


        return userInfo ;

    }
}
