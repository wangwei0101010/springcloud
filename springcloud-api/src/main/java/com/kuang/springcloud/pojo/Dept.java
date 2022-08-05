package com.kuang.springcloud.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//部门实体类
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
  //主键
  private Long deptno;
  private String dname;
/**  这个数据是存在哪个数据库的字段 微服务,一个服务对应一个数据库*/
  private String dbSource;


  public Dept(String dname) {
    this.dname = dname;
  }
}
