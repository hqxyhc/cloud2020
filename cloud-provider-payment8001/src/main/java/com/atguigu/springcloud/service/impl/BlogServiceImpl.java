package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.BlogDao;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.pojo.Blog;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.BlogService;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**PaymentServiceImpl
 * @ClassName PaymentServiceImpl
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:39
 * @Version V1.0
 **/
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    BlogDao blogDao;


    @Override
    public int add(Blog blog) {
        return blogDao.add(blog);
    }

    @Override
    public Blog getPaymentById(String id) {
        return blogDao.getBlogById(id);
    }
}
