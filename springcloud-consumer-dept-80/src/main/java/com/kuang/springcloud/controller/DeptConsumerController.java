package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerController {

  //理解,消费者,不需要有server层
  //RestTemplate.... 供我们直接调用就可以了, 注册到spring中
  //参数(url,实体Map,class<T> responseType)
  @Autowired
  private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法,简单的Restful服务模板~~~

  private static final String REST_URL_PREFIX = "http://localhost:8001";

  //dept/getById/{id}
  @RequestMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id){
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/getById/"+id,Dept.class);
  }

  @RequestMapping("/consumer/dept/add")
  public Integer add(Dept dept){
    return restTemplate.postForObject(REST_URL_PREFIX+"/dept/addDept",dept,Integer.class);
  }

  @RequestMapping("/consumer/dept/list")
  public List<Dept> list(){
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/getList",List.class);
  }


}
