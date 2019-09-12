package com.turing.website.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Meng
 * @date 2019/9/2
 */
@Configuration
public class DruidConfiguration {
    @Value("${loginusername}")
    private String loginUsername;
    @Value("${loginpassword}")
    private String loginPassword;
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        List<Filter> filters=new ArrayList<>();
        filters.add(statFilter());
        druidDataSource.setProxyFilters(filters);
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServle(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername",loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
        return servletRegistrationBean;
    }

    @Bean
    public Filter statFilter(){
        StatFilter filter=new StatFilter();
        return filter;
    }


}