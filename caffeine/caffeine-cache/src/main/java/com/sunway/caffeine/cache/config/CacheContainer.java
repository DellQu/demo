package com.sunway.caffeine.cache.config;


import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName CacheContainer
 * @Description: 缓存容器
 * @Author lsh
 * @Date 2020/8/20 13:28
 * @Version
 */
public abstract class CacheContainer<K, V> {

    private LoadingCache<K, V> cache;

    public CacheContainer(CacheOptions p) {
        cache = Caffeine.newBuilder()
                .initialCapacity(p.initialCapacity)
                .maximumSize(p.maximumSize)
                //超时自动删除
                .expireAfterAccess(p.expireAfterAccessSeconds, TimeUnit.SECONDS)
                .expireAfterWrite(p.expireAfterWriteSeconds, TimeUnit.SECONDS)
                .removalListener(new MyRemovalListener())
                .build(new DataLoader());

    }


    class DataLoader implements CacheLoader<K, V> {
        @Override
        public V load(K key) throws Exception {
            return loadOnce(key);
        }
    }

    public final V get(K k) {
        return cache.get(k);
    }

    /**
     * @Description: 添加
     * @Return void
     * @author lsh
     * @date 2020/8/20 13:33
     */
    public final void put(K k, V v) {
        cache.put(k, v);
    }

    /**
     * @Description: 移除
     * @Return void
     * @author lsh
     * @date 2020/8/20 13:33
     */
    public final void remove(K k) {
        cache.invalidate(k);
    }


    /**
     * @Description: 加载数据
     * @author lsh
     * @date 2020/8/20 13:32
     */
    public abstract V loadOnce(K k) throws Exception;

    class MyRemovalListener implements RemovalListener<K, V> {

        @Override
        public void onRemoval(@Nullable K key, @Nullable V value, @NonNull RemovalCause cause) {
            System.out.println("onRemoval");
        }
    }


}


