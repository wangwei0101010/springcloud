package com.kuang.springcloud.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import java.io.IOException;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;

import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

/**
 * @Author pypua
 * @Date 2021/4/19 16:12
 * @Version 1.0
 */
@Configuration
public class MybatisPlusConfig {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private MybatisProperties properties;

  @Autowired
  private ResourceLoader resourceLoader = new DefaultResourceLoader();

  @Autowired(required = false)
  private Interceptor[] interceptors;

  @Autowired(required = false)
  private DatabaseIdProvider databaseIdProvider;

  /**
   * 分页插件
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor(){
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    PaginationInnerInterceptor page = new PaginationInnerInterceptor();
    page.setMaxLimit(-1L);//查询所有不分页

    page.setDbType(DbType.MYSQL);
    interceptor.addInnerInterceptor(page);
    return interceptor;
  }

  @Bean
  public MybatisSqlSessionFactoryBean getBean() throws IOException {
    MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
    mybatisPlus.setDataSource(dataSource);
    mybatisPlus.setVfs(SpringBootVFS.class);
    if (StringUtils.hasText(this.properties.getConfigLocation())) {
      mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
    }
    mybatisPlus.setConfiguration((MybatisConfiguration) properties.getConfiguration());
    if (!ObjectUtils.isEmpty(this.interceptors)) {
      mybatisPlus.setPlugins(this.interceptors);
    }
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    mybatisPlus.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
    MybatisConfiguration mc = new MybatisConfiguration();
    mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
    mybatisPlus.setConfiguration(mc);
    if (this.databaseIdProvider != null) {
      mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
    }
    if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
      mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
    }
    if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
      mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
    }
    if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
      mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
    }
    return mybatisPlus;
  }
}
