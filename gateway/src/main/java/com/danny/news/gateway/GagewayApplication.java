package com.danny.news.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/14下午11:23
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class GagewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GagewayApplication.class,args);
    }

}
