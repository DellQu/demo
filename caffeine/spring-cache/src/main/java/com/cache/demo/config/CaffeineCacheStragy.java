package com.cache.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaffeineCacheManager
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 9:17
 * @Version: 1.0
 */
public abstract class CaffeineCacheStragy{

   public abstract Object get(Object key);

   public abstract Object put(Object key, Object value);

   public abstract void delete(Object key);
}
