package com.kuang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启动类
@SpringBootApplication
@MapperScan("com.kuang.springcloud.dao")
@EnableTransactionManagement
@EnableDiscoveryClient//服务发现
//开启Eureka注解,在服务启动后自动注册到Eureka中,应为是c/s架构,所有只有服务端和客户端
@EnableEurekaClient
public class DeptProvider_8002 {

  public static void main(String[] args) {
    SpringApplication.run(DeptProvider_8002.class,args);
  }
}
