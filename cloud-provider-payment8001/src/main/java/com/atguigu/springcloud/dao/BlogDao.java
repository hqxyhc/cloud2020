package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Blog;
import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName BlogDao
 * @Description: 描述
 * @Author hc
 * @Date 2021/3/5 10:56
 * @Version V1.0
 **/
@Mapper
public interface BlogDao {
    public int add(Blog blog);
    public  Blog getBlogById(@Param("id") String id);
}
