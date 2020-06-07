package com.kevin.demo.controller;

import com.kevin.demo.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @PostMapping(value="/user")
    public User createUser() {
        return new User();
    }
    @ApiOperation("test error")
    @PostMapping(value="/userError")
    public User createErrorUser(@ApiParam("error user") User user) {
        int x = 5/0;
        return user;
    }
    @GetMapping(value="/username")
    @ApiOperation("say hello with username")
    @ApiImplicitParam
    public String gerUserName(@ApiParam("company's email") String username) {
        return "hello" + username;
    }
}
