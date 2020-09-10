package com.sunway.caffeine.cache.config;

/**
 * @ClassName DefaultCacheContainer
 * @Description: 默认缓存容器
 * @Author lsh
 * @Date 2020/8/20 13:39
 * @Version
 */
public class DefaultCacheContainer<K, V> extends CacheContainer<K, V> {

    private Persistable<K, V> persistable;

    public DefaultCacheContainer(Persistable<K, V> persistable, CacheOptions p) {
        super(p);
        this.persistable = persistable;
    }

    /**
     * @param k
     * @Description: 加载数据
     * @author lsh
     * @date 2020/8/20 13:32
     */
    @Override
    public V loadOnce(K k) throws Exception {
        return persistable.load(k);
    }
}
