package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Blog;
import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:38
 * @Version V1.0
 **/
public interface BlogService {
    public int add(Blog blog);
    public Blog getPaymentById(@Param("id") String id);
}
