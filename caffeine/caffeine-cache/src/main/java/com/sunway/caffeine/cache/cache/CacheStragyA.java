package com.sunway.caffeine.cache.cache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CacheStragyA
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 14:13
 * @Version: 1.0
 */
public class CacheStragyA extends CacheStragy {

    @Override
    public Object get(Object key) {
        return cache.get(key, v -> {
            return "测试缓存A数据";
        });
    }

    @Override
    public void put(Object key, Object value) {
        cache.put(key, value);
    }

    @Override
    public void delete(Object key) {
        cache.invalidate(key);
    }
}
