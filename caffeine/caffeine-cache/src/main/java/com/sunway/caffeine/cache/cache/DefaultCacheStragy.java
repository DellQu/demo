package com.sunway.caffeine.cache.cache;

/**
 * @ClassName: DefaultCacheStragy
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 11:58
 * @Version: 1.0
 */
public class DefaultCacheStragy extends CacheStragy {

    @Override
    public Object get(Object key) {
        Object result = cache.get(key,k->{
            return "默认缓存数据";
        });
        return result;
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
