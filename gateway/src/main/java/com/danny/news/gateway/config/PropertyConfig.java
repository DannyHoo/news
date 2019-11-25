package com.danny.news.gateway.config;

import lombok.extern.slf4j.Slf4j;
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


    @Value("${spring.cloud.client.ip-address}")
    private String spring_cloud_client_ip_address;

    @Value("${server.port}")
    private String server_port;

    @PostConstruct
    public void init() {
        log.info("loadding properties:");
        log.info("project.property.property1:" + project_property_property1);
        log.info("spring.cloud.client.ip-address:" + spring_cloud_client_ip_address);
        log.info("server.port:" + server_port);
    }
}
