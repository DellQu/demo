package com.cache.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CacheService
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/8 17:59
 * @Version: 1.0
 */
@Component
public class CacheService {

    @Cacheable(value = "user", key = "123")
    public String getCache() {
        return "测试缓存";
    }
}
