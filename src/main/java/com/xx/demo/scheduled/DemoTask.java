package com.xx.demo.scheduled;

import com.xx.demo.entity.shanxin.ShanXinReqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 定时任务
 * @author lwx
 */
@Slf4j
@Component
public class DemoTask {

    private static AtomicInteger flag = new AtomicInteger(0);

    private static AtomicInteger index = new AtomicInteger(43);

    private static AtomicBoolean finish = new AtomicBoolean(false);

    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Resource
    private DeviceDataMapper deviceDataMapper;

    @Autowired
    private ShanXinReqUtil shanXinReqUtil;

    //@Scheduled(initialDelay = 1000, cron ="30 * * * * ?")
    //public void demoTask(){
    //    log.info("定时任务开始执行：{}", DateUtils.getNow());
    //}

    //@PostConstruct
    //public void initTask(){
    //    int minId = 1266505747;
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    while (true){
    //        while (flag.get() >= 15){
    //            try {
    //                Thread.sleep(30 * 1000);
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //        poolTaskExecutor.execute(() -> {
    //            flag.getAndIncrement();
    //            int localIndex = index.getAndAdd(1);
    //            log.info("now running :{}", localIndex);
    //            if (localIndex > 3333){
    //                finish.set(true);
    //                return;
    //            }
    //            List<DeviceData> deviceDatas = deviceDataMapper.selectDeviceDataList(minId + (localIndex * 100000), minId + ((localIndex + 1) * 100000));
    //            Map<String, List<DeviceData>> maps = deviceDatas.stream().collect(Collectors.groupingBy(DeviceData::getMacno));
    //            maps.forEach((k, v) -> {
    //                FileWriter fileWriter = null;
    //                try {
    //                    List<DeviceData> list = maps.get(k);
    //                    File file = new File("E:\\bak\\device_data_bak_" + k + "_" + localIndex + ".csv");
    //                    file.createNewFile();
    //                    fileWriter = new FileWriter(file);
    //                    for (DeviceData deviceData : list) {
    //                        String builder = deviceData.getType() +
    //                                ",'" +
    //                                deviceData.getData() +
    //                                "'," +
    //                                sdf.format(deviceData.getDate()) +
    //                                "\n";
    //                        fileWriter.write(builder);
    //                    }
    //                    }catch (Exception e){
    //                        e.printStackTrace();
    //                        if (e.getMessage().equals("磁盘空间不足。")){
    //                            finish.set(true);
    //                        }
    //                    }finally {
    //                        try {
    //                            if (fileWriter != null){
    //                                fileWriter.close();
    //                            }
    //                        } catch (IOException e) {
    //                            e.printStackTrace();
    //                        }
    //                    }
    //            });
    //            flag.getAndDecrement();
    //            log.info("end running :{}", localIndex);
    //        });
    //        if (finish.get()){
    //            break;
    //        }
    //    }
    //    log.info("==========================hhhhhhhhhh=========================");
    //}

    @PostConstruct
    public void initTask(){
        int minId = 1621798203;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        while (true){
            int localIndex = index.getAndAdd(1);
            log.info("now running :{}", localIndex);
            List<DeviceData> deviceDatas = deviceDataMapper.selectDeviceDataList(minId + (localIndex * 1000000), minId + ((localIndex + 1) * 1000000));
            if (deviceDatas.size() < 1){
                break;
            }
            Map<String, List<DeviceData>> maps = deviceDatas.stream().collect(Collectors.groupingBy(DeviceData::getMacno));
            maps.forEach((k, v) -> {
                FileWriter fileWriter = null;
                try {
                    List<DeviceData> list = maps.get(k);
                    File file = new File("E:\\bak\\device_data_bak_" + k + ".csv");
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    fileWriter = new FileWriter(file);
                    for (DeviceData deviceData : list) {
                        String builder = deviceData.getType() +
                                ",'" +
                                deviceData.getData() +
                                "'," +
                                sdf.format(deviceData.getDate().length() == 8 ? sdf2.parse(deviceData.getDate()) : sdf1.parse(deviceData.getDate())) +
                                "\n";
                        fileWriter.write(builder);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (fileWriter != null){
                            fileWriter.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            log.info("end running :{}", localIndex);
        }
        log.info("==========================hhhhhhhhhh=========================");
    }

    //@PostConstruct
    //public void initTask(){
    //    shanXinReqUtil.send("15524705689");
    //}


}
