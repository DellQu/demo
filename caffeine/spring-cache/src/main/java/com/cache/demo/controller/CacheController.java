package com.cache.demo.controller;

import com.cache.demo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: cacheController
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/8 17:58
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping(value = "/get")
    public String getCache() {
        String cache = cacheService.get("test");
        return cache;
    }
}
