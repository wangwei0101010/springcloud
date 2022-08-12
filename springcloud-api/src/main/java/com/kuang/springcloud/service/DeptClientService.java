package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value ="SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory =DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

  @GetMapping("/dept/getById/{id}")
  Dept queryById(@PathVariable("id") Long id);

  @GetMapping("/dept/getList")
  List<Dept> queryAll();

  @PostMapping("/dept/addDept")
  boolean addDept(Dept dept);

}
