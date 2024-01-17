package com.xx.demo.service.impl;

import com.xx.demo.mapper.DemoMapper;
import com.xx.demo.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 接入系统表 服务实现类
 * </p>
 *
 * @author xiaoyu
 * @since 2020-03-16
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public void execDDL(String sql) {
        demoMapper.execDDL(sql);
    }
}
