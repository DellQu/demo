package com.sunway.caffeine.cache.service;

import com.sunway.caffeine.cache.cache.SpringUtil;
import com.sunway.caffeine.cache.service.impl.AlarmBasicRealCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CaffeineCache
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/14 8:54
 * @Version: 1.0
 */
@Component
public class CaffeineCache {

    private CaffeineCacheStrategy caffeineCacheStrategy;

    public CaffeineCacheStrategy getCaffeineCacheStrategy() {
        return caffeineCacheStrategy;
    }

    public void setCaffeineCacheStrategy(CaffeineCacheStrategy caffeineCacheStrategy) {
        this.caffeineCacheStrategy = caffeineCacheStrategy;
    }

    public Object get(String key) {
        //caffeineCacheStrategy.getClass().getSimpleName()
        return ((CaffeineCacheStrategy) SpringUtil.getBean((new StringBuilder()).append(Character.toLowerCase(caffeineCacheStrategy.getClass().getSimpleName().charAt(0))).append(caffeineCacheStrategy.getClass().getSimpleName().substring(1)).toString())).get(key);
    }
}
