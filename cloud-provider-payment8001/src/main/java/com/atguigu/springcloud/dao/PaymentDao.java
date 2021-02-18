package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:16
 * @Version V1.0
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public  Payment getPaymentById(@Param("id") Long id);
}
