package com.kuang.springcloud;

import com.kuang.myrule.KuangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//Ribbon 和Eureka 整合以后,客户端可以直接调用,不用关心ip和端口
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能加载我们自定义的Ribbon类,需要和启动类同级别,不然会被扫描到.
@RibbonClient(name = "springcloud-provider-dept",configuration = KuangRule.class)
public class DeptConsumer_80 {

  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer_80.class,args);
  }

}
