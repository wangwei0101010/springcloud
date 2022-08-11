package com.kuang.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于 spring中的 applicationContext.xml配置文件
public class ConfigBean {

  //配置负载均衡实现RestTemplate
  /**
   *
   * IRule
   *  RoundRobinRule 轮询
   *  RandomRule 随机
   *  AvailabilityFilteringRule :回先过滤掉,跳闸
   *
   *
   */

  @Bean
  @LoadBalanced // Ribbon
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }


}
