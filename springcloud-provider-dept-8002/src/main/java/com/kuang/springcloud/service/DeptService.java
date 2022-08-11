package com.kuang.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuang.springcloud.pojo.Dept;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeptService extends IService<Dept> {
  public int addDept(Dept dept);
  public Dept getById(Long id);
  public List<Dept> getList();

}
