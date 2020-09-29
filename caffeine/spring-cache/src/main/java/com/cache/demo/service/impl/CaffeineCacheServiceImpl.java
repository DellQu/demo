package com.cache.demo.service.impl;

import com.cache.demo.service.CaffeineCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CaffeineCacheServiceImpl
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/10 18:21
 * @Version: 1.0
 */
@Service
public class CaffeineCacheServiceImpl implements CaffeineCacheService {

    private final String CACHE_NAME = "test_cache";

    @Autowired
    private ApplicationContext applicationContext;

    @Cacheable(value = CACHE_NAME, key = "#p0")
    @Override
    public String get(String key) {
        return "测试缓存";
    }

    @CacheEvict(value = CACHE_NAME, key = "#p0")
    @Override
    public void delete(String key) {

    }

    @CachePut(value = CACHE_NAME,key = "#p0")
    @Override
    public String put(String key, String value) {
        return value;
    }

    @Override
    public Object getAll(String key) {
        CaffeineCacheManager caffeineCacheManager = applicationContext.getBean(CaffeineCacheManager.class);
        Cache cache = caffeineCacheManager.getCache(key);
        return cache.getNativeCache();
    }
}
