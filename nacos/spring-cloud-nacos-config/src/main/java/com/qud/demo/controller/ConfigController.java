package com.qud.demo.controller;

import com.qud.demo.config.SchoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigController
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/15 16:05
 * @Version: 1.0
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private SchoolConfig schoolConfig;

    /**
     * http://localhost:8080/config/get
     */
    @RequestMapping("/get")
    public String get() {
        return schoolConfig.getLevel() + "----" + schoolConfig.getArea();
    }
}
