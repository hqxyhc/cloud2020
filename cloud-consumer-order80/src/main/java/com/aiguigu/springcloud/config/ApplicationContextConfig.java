package com.aiguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/17 0:28
 * @Version V1.0
 **/
@Configuration

public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //轮询负载均衡
    public RestTemplate getRestTenplate(){
        return  new RestTemplate();
    }
}
