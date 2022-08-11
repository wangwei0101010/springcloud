package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerController {

  @Autowired
  private DeptClientService deptClientService = null;

  @RequestMapping("/consumer/dept/add")
  public boolean add(Dept dept) {
    return deptClientService.addDept(dept);
  }

  @RequestMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id) {
    return deptClientService.queryById(id);
  }

  @RequestMapping("/consumer/dept/list")
  public List<Dept> list() {
    return deptClientService.queryAll();
  }


}
