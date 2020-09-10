package com.sunway.caffeine.cache.controller;

import com.sunway.caffeine.cache.entity.User;
import com.sunway.caffeine.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author lsh
 * @Date 2020/8/20 14:02
 * @Version
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public void users() throws Exception {
        userService.load(110L);
    }

    @GetMapping("/users/id")
    @ResponseBody
    public User findUserById() throws Exception {
        return userService.get(110L);
    }


}