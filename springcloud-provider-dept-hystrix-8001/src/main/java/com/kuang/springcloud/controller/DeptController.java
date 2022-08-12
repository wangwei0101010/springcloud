package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;

  //失败了调用hystrixGet方法
  @HystrixCommand(fallbackMethod = "hystrixGet")
  @GetMapping("/dept/getById/{id}")
  public Dept get(@PathVariable("id") Long id) {
    Dept dept = deptService.getById(id);

    if (dept == null) {
      throw new RuntimeException("id=>" + id + ",不存在该用户");
    }
    return dept;
  }

  //备选方案
  public Dept hystrixGet(@PathVariable("id") Long id) {
    return new Dept().setDeptno(id).setDname("id不存在,我是@Hystirx");
  }

}
