package com.sunway.caffeine.cache.service.impl;

import com.sunway.caffeine.cache.service.CaffeineCacheStrategy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName: LongName2Id
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/14 11:30
 * @Version: 1.0
 */
@Service
public class LongName2Id implements CaffeineCacheStrategy {

    private final static String CACHE_NAME = "tag_name";

    @Override
    @Cacheable(value = CACHE_NAME)
    public Object get(String key) {
        return "测点描述";
    }

}
