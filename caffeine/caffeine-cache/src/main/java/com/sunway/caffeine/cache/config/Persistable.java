package com.sunway.caffeine.cache.config;

/**
 * @ClassName Persistable
 * @Description: 加载数据源
 * @Author lsh
 * @Date 2020/8/20 13:42
 * @Version
 */
public interface Persistable<K, V> {
    V load(K k) throws Exception;
}
