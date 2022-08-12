package com.kuang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
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

/**
 * 监控页面 ,需要开启7001 和hystrix8001,然后访问8001,然后通过url监控页面观察
 * http://localhost:9001/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8001%2Factuator%2Fhystrix.stream&title=demo
 * */
  //增加一个servlet,监控页面使用
  @Bean
  public ServletRegistrationBean getServlet() {
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(
        new HystrixMetricsStreamServlet());
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    return registrationBean;

  }
}
