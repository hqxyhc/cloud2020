#1.cloud2020
cloud-api-commons:公共包 
cloud-consumer-order80:消费端
cloud-eureka-server7001:注册中心
cloud-eureka-server7002:注册中心
cloud-provider-payment8001:生产端
cloud-provider-payment8002:生产端
#2.注册中心不同时注意点
@EnableEurekaClient 只有在注册中心为eureka时使用，
服务发现使用@EnableDiscoveryClient
使用consul或者zookeeper作为注册中心时注册服务时使用@EnableDiscoveryClient
zookeeper
consul和zookeeper需要自己百度教程安装。

注册中心不同时：看pom，application.yml和启动类注释
