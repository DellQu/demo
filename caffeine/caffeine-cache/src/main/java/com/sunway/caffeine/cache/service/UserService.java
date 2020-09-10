package com.sunway.caffeine.cache.service;

import com.sunway.caffeine.cache.config.CacheService;
import com.sunway.caffeine.cache.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author lsh
 * @Date 2020/8/20 13:45
 * @Version
 */
@Slf4j
@Service
public class UserService extends CacheService<Long, User> {


    /**
     * @return
     * @Description:
     * @Return cache.entity.User
     * @author lsh
     * @date 2020/8/20 13:53
     */
    @Override
    public User load(Long id) throws Exception {
        System.out.println("query redis");
        User user = new User(110L, "张三", "123456");
        return user;
    }


}
