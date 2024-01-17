package com.xx.demo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author lwx
 */
@Slf4j
@Component
public class DemoTask {

    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

}
