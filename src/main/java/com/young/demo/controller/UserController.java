package com.young.demo.controller;


import com.young.demo.model.entity.User;
import com.young.demo.model.view.ApiResult;
import static com.young.demo.model.view.ApiResult.apiResult;

import com.young.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Api(value = "user endpoints", tags = "User")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/user/app/index",
            method = GET
    )
    public ApiResult<User> index()
    {
        User user = userService.aaa(1L);
        return apiResult(user);
    }
}
