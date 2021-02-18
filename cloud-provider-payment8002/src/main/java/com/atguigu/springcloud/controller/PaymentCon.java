package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentCon
 * @Description: 描述
 * @Author hc
 * @Date 2021/2/16 23:44
 * @Version V1.0
 **/
@RestController
@Slf4j
public class PaymentCon {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,i);
        }else{
            return new CommonResult(444,"插入数据失败,serverPort:"+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"查询数据成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询id:"+id+",serverPort:"+serverPort);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("----------element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("serviceId:"+instance.getServiceId()
                    +",主机名称:"+instance.getHost()
                    +",端口号:"+instance.getPort()
                    +",url地址:"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
