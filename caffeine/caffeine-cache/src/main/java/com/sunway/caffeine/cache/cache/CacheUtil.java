package com.sunway.caffeine.cache.cache;

import org.springframework.stereotype.Component;

/**
 * @ClassName: CacheService
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 13:44
 * @Version: 1.0
 */
@Component
public class CacheUtil {

    private CacheStragy cacheStragy = new DefaultCacheStragy();

    public CacheStragy getCacheStragy() {
        return cacheStragy;
    }

    public void setCacheStragy(CacheStragy cacheStragy) {
        this.cacheStragy = cacheStragy;
    }

    public Object get(Object key) {
        return cacheStragy.get(key);
    }

    public void put(Object key, Object value) {
        cacheStragy.put(key, value);
    }

    public void delete(Object key) {
        cacheStragy.delete(key);
    }
}
