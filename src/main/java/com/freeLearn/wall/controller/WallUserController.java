package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class WallUserController {

    //TODO

    @RequestMapping(value = "/weChat/register", method = RequestMethod.POST)
    public CommonResult<T> weChatRegister(){

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<T> register(){

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult<T> login(){

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonResult<T> logout(){

    }
}
