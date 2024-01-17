package com.xx.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备历史数据记录 Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-03-23
 */
@Mapper
public interface DemoMapper extends BaseMapper<DeviceData> {

    void execDDL(@Param("sql") String sql);

}
