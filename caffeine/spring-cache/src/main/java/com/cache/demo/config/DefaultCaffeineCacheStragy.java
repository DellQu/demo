package com.cache.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaffeineCacheSubB
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 9:31
 * @Version: 1.0
 */
public class DefaultCaffeineCacheStragy extends CaffeineCacheStragy {

    private static final String CACHE_NAME = "cache_name";

    private static Cache cache;

    static {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder();
        cacheBuilder.expireAfterAccess(3L, TimeUnit.SECONDS);
        caffeineCacheManager.setCaffeine(cacheBuilder);
        cache = caffeineCacheManager.getCache(CACHE_NAME);
    }

    @Override
    public Object get(Object key) {
        //通过key到Caffeine中获取,获取到值返回,获取不到值去redis中get 并存储在caffeine中
        Cache.ValueWrapper valueWrapper = cache.get(key);
        Object result = null;
        if (valueWrapper == null) {
            result = put(key, "测试缓存");
        }else {
            result = valueWrapper.get();
        }

        return result;
    }

    @Override
    public Object put(Object key, Object value) {
        cache.put(key, value);
        Cache.ValueWrapper valueWrapper = cache.get(key);
        Object result = valueWrapper.get();
        return result;
    }

    @Override
    public void delete(Object key) {
        cache.evict(key);
    }

    @Override
    public Object getAll() {
        return cache.getNativeCache();
    }
}
