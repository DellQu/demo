package com.cache.demo.controller;

import com.cache.demo.config.CaffeineCacheStragyA;
import com.cache.demo.service.CaffeineCache;
import com.cache.demo.service.CaffeineCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: cacheController
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/8 17:58
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {

    @Autowired
    private CaffeineCacheService cacheService;

    @Autowired
    private CaffeineCache caffeineCache;

    @PostMapping(value = "/get")
    public String getCache() {
        caffeineCache.setCaffeineCacheStragy(new CaffeineCacheStragyA());
        String cache = (String) caffeineCache.get("test");
        return cache;
    }
}
