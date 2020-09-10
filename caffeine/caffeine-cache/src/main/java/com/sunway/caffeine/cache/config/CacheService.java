package com.sunway.caffeine.cache.config;

/**
 * @ClassName CacheService
 * @Description: 缓存服务抽象
 * @Author lsh
 * @Date 2020/8/20 13:37
 * @Version
 */
public abstract class CacheService<K, V> implements Persistable<K, V> {

    private final CacheContainer<K, V> container;

    public CacheService() {
        this(CacheOptions.defaultCacheOptions());
    }

    public CacheService(CacheOptions p) {
        container = new DefaultCacheContainer<>(this, p);
    }

    /**
     * 通过key获取对象
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return container.get(key);
    }

    /**
     * 手动移除缓存
     * @param key
     * @return
     */
    public void remove(K key) {
        container.remove(key);
    }

    /**
     * 手动加入缓存
     * @param key
     * @return
     */
    public void put(K key, V v) {
        this.container.put(key, v);
    }

    public CacheContainer<K, V> getContainer() {
        return container;
    }


}
