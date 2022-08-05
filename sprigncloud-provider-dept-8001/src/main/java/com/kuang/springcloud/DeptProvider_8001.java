package com.kuang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启动类
@SpringBootApplication
@MapperScan("com.kuang.springcloud.dao")
@EnableTransactionManagement
public class DeptProvider_8001 {

  public static void main(String[] args) {
    SpringApplication.run(DeptProvider_8001.class,args);
  }
}
