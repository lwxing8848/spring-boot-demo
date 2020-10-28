package com.xx.demo.scheduled;

import com.xx.demo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author lwx
 */
@Slf4j
@Component
public class DemoTask {

    @Scheduled(cron ="*/5 * * * * ?")
    public void demoTask(){
        log.info("定时任务开始执行：{}", DateUtils.getNow());
    }

}
