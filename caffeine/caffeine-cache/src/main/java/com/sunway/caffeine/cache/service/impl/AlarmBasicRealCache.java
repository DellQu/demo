package com.sunway.caffeine.cache.service.impl;

import com.sunway.caffeine.cache.service.CaffeineCacheStrategy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AlarmBasicRealCache
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/14 8:56
 * @Version: 1.0
 */
@Service
public class AlarmBasicRealCache implements CaffeineCacheStrategy {

    private final static String CACHE_NAME = "alarm_name";

    @Override
    @Cacheable(value = CACHE_NAME)
    public Object get(String key) {
        return "报警描诉";
    }
}
