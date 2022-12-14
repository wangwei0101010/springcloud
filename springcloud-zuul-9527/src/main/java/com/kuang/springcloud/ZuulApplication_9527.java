package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//启动类
@SpringBootApplication
//使用proxy
@EnableZuulProxy
public class ZuulApplication_9527 {

  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication_9527.class,args);
  }

}
