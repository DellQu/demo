package com.qud.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SchoolConfig
 * @Description: TODO
 * @Author: qudi
 * @Date: 2020/9/15 16:12
 * @Version: 1.0
 */
@Configuration
@RefreshScope
public class SchoolConfig {

    /**
     * 学校面积
     */
    @Value("${school.area}")
    private double area;

    /**
     * 学校等级
     */
    @Value("${school.level}")
    private String level;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
