package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//开启远程配置
@EnableConfigServer
public class Config_server_3344 {

  public static void main(String[] args) {
    SpringApplication.run(Config_server_3344.class,args);
  }

}
