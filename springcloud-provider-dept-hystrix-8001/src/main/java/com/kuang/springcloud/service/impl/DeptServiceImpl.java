package com.kuang.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.springcloud.dao.DeptMapper;
import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements
    DeptService {

  @Override
  public int addDept(Dept dept) {
    return baseMapper.insert(dept);
  }

  @Override
  public Dept getById(Long id) {
    LambdaQueryWrapper<Dept> deptLambdaQueryWrapper = new LambdaQueryWrapper<>();
    deptLambdaQueryWrapper.eq(Dept::getDeptno,id);
    return baseMapper.selectOne(deptLambdaQueryWrapper);
  }

  @Override
  public List<Dept> getList() {
    return baseMapper.selectList(new QueryWrapper<>());
  }
}
