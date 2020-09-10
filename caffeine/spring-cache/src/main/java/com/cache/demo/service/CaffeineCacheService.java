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
public interface CacheService {

    String get(String key);

    void delete(String key);

    String put(String key, String value);
}
