package com.sunway.caffeine.cache.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CacheStragy
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/11 11:57
 * @Version: 1.0
 */
public abstract class CacheStragy {

    protected static Cache cache;

    protected final static int DEFAULT_INITIAL_CAPACITY = 1024;

    protected final static int DEFAULT_MAXIMUM_SIZE = 65536;

    protected final static int DEFAULT_EXPIRE_AFTER_ACCESS_SECONDS = (int) (60 * 60 * 24);

    protected final static int DEFAULT_EXPIRE_AFTER_WRITE_SECONDS = (int) (60 * 60 * 24);

    static {
        cache = Caffeine.newBuilder()
                .initialCapacity(DEFAULT_INITIAL_CAPACITY)
                .maximumSize(DEFAULT_MAXIMUM_SIZE)
                //超时自动删除
                .expireAfterAccess(DEFAULT_EXPIRE_AFTER_ACCESS_SECONDS, TimeUnit.SECONDS)
                .expireAfterWrite(DEFAULT_EXPIRE_AFTER_WRITE_SECONDS, TimeUnit.SECONDS)
                .build();
    }

    public abstract Object get(Object key);

    public abstract void put(Object key, Object value);

    public abstract void delete(Object key);
}
