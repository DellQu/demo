package com.sunway.caffeine.cache.controller;

import com.sunway.caffeine.cache.cache.CacheUtil;
import com.sunway.caffeine.cache.entity.User;
import com.sunway.caffeine.cache.service.CaffeineCache;
import com.sunway.caffeine.cache.service.TestService;
import com.sunway.caffeine.cache.service.UserService;
import com.sunway.caffeine.cache.service.impl.AlarmBasicRealCache;
import com.sunway.caffeine.cache.service.impl.LongName2Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private CacheUtil cacheUtil;

    @Autowired
    private CaffeineCache caffeineCache;

    @Autowired
    private TestService testService;

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

    @PostMapping("/get")
    public Object getCache(){
        caffeineCache.setCaffeineCacheStrategy(new AlarmBasicRealCache());
        System.out.println(caffeineCache.get("123"));
        caffeineCache.setCaffeineCacheStrategy(new LongName2Id());
        System.out.println(caffeineCache.get("123"));
        return "成功";
    }

    @PostMapping("/getA")
    public Object getCacheA(){
        return testService.get(110L);
    }
}
