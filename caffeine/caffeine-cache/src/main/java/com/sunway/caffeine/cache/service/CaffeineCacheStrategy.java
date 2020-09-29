package com.sunway.caffeine.cache.service;

/**
 * @ClassName: CaffeineCacheStrategy
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/14 8:50
 * @Version: 1.0
 */
public interface CaffeineCacheStrategy {

    Object get(String key);
}
