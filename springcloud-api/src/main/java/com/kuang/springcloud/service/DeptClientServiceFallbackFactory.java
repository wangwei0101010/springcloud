package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {


  @Override
  public DeptClientService create(Throwable throwable) {
    return new DeptClientService() {
      @Override
      public Dept queryById(Long id) {
        return new Dept().setDeptno(id)
            .setDname("id=>" + id + "没有对应的信息,客户端提供了降级信息,"
                + "这个服务现在被关闭");
      }

      @Override
      public List<Dept> queryAll() {
        return null;
      }

      @Override
      public boolean addDept(Dept dept) {
        return false;
      }
    };
  }
}
