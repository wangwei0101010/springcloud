package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

  @Autowired
  private DeptService service;


  @GetMapping("/dept/addDept")
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


}
