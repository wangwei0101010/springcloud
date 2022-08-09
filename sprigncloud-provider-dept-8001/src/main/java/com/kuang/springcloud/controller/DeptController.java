package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

  @Autowired
  private DeptService service;

  //获取一些配置的信息,得到具体的微服务
  @Autowired
  private DiscoveryClient client;



  @PostMapping("/dept/addDept")
  public int addDept(Dept dept) {
    return service.addDept(dept);
  }


  @GetMapping("/dept/getById/{id}")
  public Dept getById(@PathVariable("id") Long id) {
    return service.getById(id);
  }


  @GetMapping("/dept/getList")
  public List<Dept> getList() {
    return service.getList();
  }

  //注册进来的微服务,获取一些消息
  @GetMapping("/dept/discovery")
  public Object discovery(){
    //获取微服务列表的清单
    List<String> services = client.getServices();
    System.err.println("discovery->services:"+services);
    //得到一个具体的微服务信息
    List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
    instances.forEach(i ->{
      System.out.println(i.getHost());
      System.out.println(i.getPort());
      System.out.println(i.getUri());
      System.out.println(i.getServiceId());
        }
    );
    return this.client;
  }


}
