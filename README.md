1.cloud2020

    cloud-api-commons:公共包 
    cloud-consumer-order80:消费端
    cloud-eureka-server7001:注册中心
    cloud-eureka-server7002:注册中心
    cloud-provider-payment8001:生产端
    cloud-provider-payment8002:生产端

2.注册中心不同时注意点

    @EnableEurekaClient 只有在注册中心为eureka时使用，
    服务发现使用@EnableDiscoveryClient
    使用consul或者zookeeper作为注册中心时注册服务时使用@EnableDiscoveryClient
    zookeeper
    consul和zookeeper需要自己百度教程安装。
    注册中心不同时：看pom，application.yml和启动类注释
    
 3.三个注册中心异同点

    CAP
    	C:Consistency(强一致性)
    	A:Availability(可用性)
    	P:Partition tolerance(分区容错)
    	CAP理论关注粒度是数据，而不是整体系统设计的策略
    经典CAP图
    	AP(Eureka)
    	CP(Zookeeper/Consul)
    CAP理论的核心是: -个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求,
        最多只能同时较好的满足两个
        因此，根据CAP原理将NoSQL数据库分成了满足CA原则、满足CP原则和满足AP原则三大类:
        CA-单点集群，满足一致性，可用性的系统，通常在可扩展性上不太强大。
        CP-满足一 致性,分区容忍必的系统，通常性能不是特别高。
        AP -满足可用性,分区容忍性的系统，通常可能对一 致性要求低一 些。
