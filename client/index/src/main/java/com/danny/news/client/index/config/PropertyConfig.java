package com.danny.news.client.index.config;

import com.danny.news.client.common.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/19下午8:07
 */
@Slf4j
@Component
public class PropertyConfig {
    @Value("${project.property.property1}")
    private String project_property_property1;

    @Autowired
    private RedisUtils redisUtils;

    @PostConstruct
    public void init() {
        log.info("loadding properties:");
        log.info("project.property.property1:" + project_property_property1);
        log.info("entity64061:"+redisUtils.get("entity64061"));
    }
}
