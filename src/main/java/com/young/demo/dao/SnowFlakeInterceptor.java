package com.young.demo.dao;

import com.young.demo.util.SnowFlake;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class SnowFlakeInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnowFlakeInterceptor.class);

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
