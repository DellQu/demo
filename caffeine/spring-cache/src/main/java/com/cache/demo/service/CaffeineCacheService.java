package com.cache.demo.service;

/**
 * @ClassName: CaffeineCacheService
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 10:05
 * @Version: 1.0
 */
public interface CaffeineCacheService {

    String get(String key);

    void delete(String key);

    String put(String key, String value);
}
