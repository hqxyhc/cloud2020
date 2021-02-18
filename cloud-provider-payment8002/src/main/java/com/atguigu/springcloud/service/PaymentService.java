package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:38
 * @Version V1.0
 **/
public interface PaymentService {
    public int create(Payment payment);
    public  Payment getPaymentById(@Param("id") Long id);
}
