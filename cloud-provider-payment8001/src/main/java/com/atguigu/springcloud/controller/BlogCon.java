package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.Blog;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName BlogCon
 * @Description: 描述
 * @Author hc
 * @Date 2021/3/5 10:55
 * @Version V1.0
 **/
@RestController
@Slf4j
public class BlogCon {
    @Resource
    BlogService blogService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/blog/add")
    public CommonResult<Blog> add(@RequestBody Blog blog){
        blog.setId(UUID.randomUUID().toString().trim().replace("-", ""));
        blog.setWriter("admin");
        blog.setLastTime(new Date().toString());
        blog.setReadNum(1);
        blog.setLikeNum(1);
        int i = blogService.add(blog);
        if(i>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,i);
        }else{
            return new CommonResult(444,"插入数据失败,serverPort:"+serverPort);
        }
    }

    @GetMapping(value = "/blog/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id){
        Blog blog = blogService.getPaymentById(id);
        if(blog!=null){
            return new CommonResult(200,"查询数据成功,serverPort:"+serverPort,blog);
        }else{
            return new CommonResult(444,"没有对应记录，查询id:"+id+",serverPort:"+serverPort);
        }
    }
}
