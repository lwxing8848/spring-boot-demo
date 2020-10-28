package com.xx.demo.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * @author lwx
 * @date 2020/1/8
 * @Description 异步异常捕获配置类
 */
@Configuration
public class AsyncExceptionConfig implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new IpDestinationImportAsyncExceptionHandler();
    }

    class IpDestinationImportAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        @Override
        public void handleUncaughtException(Throwable ex, Method method, Object... params) {
            ex.getMessage();
            ex.getStackTrace();
        }
    }
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        //线程池活跃的线程数
        pool.setCorePoolSize(5);
        //线程池最大活跃的线程数
        pool.setMaxPoolSize(10);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        pool.setThreadNamePrefix("异步线程池-");
        return pool;
    }


}
