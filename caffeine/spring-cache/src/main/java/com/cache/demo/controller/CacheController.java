package com.cache.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.cache.demo.config.CaffeineCacheStragyA;
import com.cache.demo.service.CaffeineCache;
import com.cache.demo.service.CaffeineCacheService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: cacheController
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/8 17:58
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/cache")
@RefreshScope
public class CacheController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Autowired
    private CaffeineCacheService cacheService;

    @Autowired
    private CaffeineCache caffeineCache;

    @PostMapping(value = "/get")
    public void getCache() {
        for (int i = 0; i < 10; i++) {
            cacheService.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService.get("key" + i));
        }


        Map<String, Object> all = null;
        try {
            all = ObjToMap(cacheService.getAll("test_cache"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> result = (Map<String, String>) all.get("cache");
        System.out.println(result.values());
    }

    public Map<String, Object> ObjToMap(Object obj) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }
}

