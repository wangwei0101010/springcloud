package com.kuang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启动类
@SpringBootApplication
@MapperScan("com.kuang.springcloud.dao")
@EnableTransactionManagement
@EnableDiscoveryClient//服务发现
//开启Eureka注解,在服务启动后自动注册到Eureka中,应为是c/s架构,所有只有服务端和客户端
@EnableEurekaClient
/**
 * 断路器注解,不是@EnableHystrix注解!!!!
 * */
@EnableCircuitBreaker
public class HystrixDeptProvider_8001 {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDeptProvider_8001.class,args);
  }
}
