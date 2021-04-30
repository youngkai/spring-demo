package com.young.demo.configuration;

import com.young.demo.dao.SnowFlakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConfiguration {
    @Bean
    public SnowFlakeInterceptor mybatisInterceptor() {
        SnowFlakeInterceptor interceptor = new SnowFlakeInterceptor();
        Properties properties = new Properties();
        // 可以调用properties.setProperty方法来给拦截器设置一些自定义参数
        interceptor.setProperties(properties);
        return interceptor;
    }
}
