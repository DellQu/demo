package com.cache.demo.service;

import com.cache.demo.config.CaffeineCacheStragy;
import com.cache.demo.config.DefaultCaffeineCacheStragy;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CaffeineCache
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 9:32
 * @Version: 1.0
 */
@Component
public class CaffeineCache {

    private CaffeineCacheStragy caffeineCacheStragy = new DefaultCaffeineCacheStragy();

    public CaffeineCacheStragy getCaffeineCacheStragy() {
        return caffeineCacheStragy;
    }

    public void setCaffeineCacheStragy(CaffeineCacheStragy caffeineCacheStragy) {
        this.caffeineCacheStragy = caffeineCacheStragy;
    }

    public Object get(Object key) {
        return caffeineCacheStragy.get(key);
    }

    public Object put(Object key, Object value) {
        return caffeineCacheStragy.put(key, value);
    }

    public Object getAll() {
        return caffeineCacheStragy.getAll();
    }
}
