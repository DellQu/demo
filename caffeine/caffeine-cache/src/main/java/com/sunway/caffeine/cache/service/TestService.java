package com.sunway.caffeine.cache.service;

import com.sunway.caffeine.cache.config.CacheService;
import com.sunway.caffeine.cache.entity.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName: testService
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 15:46
 * @Version: 1.0
 */
@Service
public class TestService extends CacheService<Long, User> {
    @Override
    public User load(Long aLong) throws Exception {
        System.out.println("query redis");
        User user = new User(110L, "李四", "123456");
        return user;
    }
}
