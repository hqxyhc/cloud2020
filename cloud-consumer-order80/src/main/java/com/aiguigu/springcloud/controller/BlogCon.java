package com.aiguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.Blog;
import com.atguigu.springcloud.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName BlogCon
 * @Description: 描述
 * @Author hc
 * @Date 2021/3/5 9:58
 * @Version V1.0
 **/
@RestController
@Slf4j
@RequestMapping("/my")
public class BlogCon {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @PostMapping("/consumer/blog/add")
    public CommonResult<Blog> create(@RequestBody Blog blog){
        System.out.println(blog.getContent());
        return restTemplate.postForObject(PAYMENT_URL+"/blog/add",blog, CommonResult.class);
    }

    @GetMapping("/consumer/blog/get/{id}")
    public CommonResult<Blog> getPaymentById(@PathVariable("id") String id){
        return restTemplate.getForObject(PAYMENT_URL+"/blog/get/"+id,CommonResult.class);
    }
}
