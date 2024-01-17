///*
// *
// *  Copyright 2020 byai.com All right reserved. This software is the
// *  confidential and proprietary information of byai.com ("Confidential
// *  Information"). You shall not disclose such Confidential Information and shall
// *  use it only in accordance with the terms of the license agreement you entered
// *  into with byai.com.
// * /
// */
//
//package com.xx.demo.config;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
//import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//import com.baomidou.mybatisplus.generator.config.rules.DbType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import org.apache.velocity.VelocityContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author annpeter.it@gmail.com
// * @date 05/01/2018
// */
//public class MpGenerator extends AutoGenerator {
//    private static final Logger logger = LoggerFactory.getLogger(MpGenerator.class);
//    public static final String AUTHOR = "mingfu";
//
//    public static void main(String[] args) {
//        String packageName = "tmp";
//        generateByTables(packageName, new String[]{
//                "cs_seat_status_statistics"
//        });
//    }
//
//    @Override
//    public void execute() {
//        try {
//            logger.debug("==========================准备生成文件...==========================");
//            // 初始化配置
//            initConfig();
//
//            List<TableInfo> tableInfoList = config.getTableInfoList();
//
//            for (TableInfo tableInfo : tableInfoList) {
//                // if (tableInfo.getName().equals("user_info")) {
//                //     List<TableField> fields = tableInfo.getFields();
//                //     Iterator<TableField> iterator = fields.iterator();
//                //     // while (iterator.hasNext()) {
//                //     //     TableField tableField = iterator.next();
//                //     //     if (tableField.getName().equals("nick_name")) {
//                //     //         iterator.remove();
//                //     //     }
//                //     //
//                //     //     if (tableField.getName().equals("is_indata")) {
//                //     //         tableField.setColumnType(DbColumnType.BOOLEAN);
//                //     //     }
//                //     // }
//                // }
//            }
//
//            // 创建输出文件路径
//            Method mkdirsMethod = BeanUtils.findDeclaredMethod(this.getClass(), "mkdirs", Map.class);
//            mkdirsMethod.setAccessible(true);
//            mkdirsMethod.invoke(this, config.getPathInfo());
//
//            // 获取上下文
//            Method analyzeDataMethod = BeanUtils.findDeclaredMethod(this.getClass(), "analyzeData", ConfigBuilder.class);
//            analyzeDataMethod.setAccessible(true);
//            Map<String, VelocityContext> ctxData = (Map<String, VelocityContext>) analyzeDataMethod.invoke(this, config);
//
//            // 循环生成文件
//            for (Map.Entry<String, VelocityContext> ctx : ctxData.entrySet()) {
//                Method batchOutputMethod = BeanUtils.findDeclaredMethod(this.getClass(), "batchOutput", String.class, VelocityContext.class);
//                batchOutputMethod.setAccessible(true);
//                batchOutputMethod.invoke(this, ctx.getKey(), ctx.getValue());
//            }
//
//            // 打开输出目录
//            if (config.getGlobalConfig().isOpen()) {
//                try {
//                    String osName = System.getProperty("os.name");
//                    if (osName != null) {
//                        if (osName.contains("Mac")) {
//                            Runtime.getRuntime().exec("open " + config.getGlobalConfig().getOutputDir());
//                        } else if (osName.contains("Windows")) {
//                            Runtime.getRuntime().exec("cmd /c start " + config.getGlobalConfig().getOutputDir());
//                        } else {
//                            logger.debug("文件输出目录:" + config.getGlobalConfig().getOutputDir());
//                        }
//                    }
//                } catch (IOException e) {
//                    logger.error("io exception", e);
//                }
//            }
//            logger.debug("==========================文件生成完成！！！==========================");
//        } catch (Exception e) {
//            logger.error("==========================文件生成失败！！！==========================", e);
//        }
//    }
//
//    private static void generateByTables(String packageName, String... tableNames) {
//        GlobalConfig config = new GlobalConfig();
//        String dbUrl = "jdbc:mysql://172.22.24.46:3306/byrobot_prod";
//        com.baomidou.mybatisplus.generator.config.DataSourceConfig dataSourceConfig = new com.baomidou.mybatisplus.generator.config.DataSourceConfig();
//        dataSourceConfig.setDbType(DbType.MYSQL)
//                .setTypeConvert(new MySqlTypeConvert() {
//                    // 自定义数据库表字段类型转换【可选】
//                    @Override
//                    public DbColumnType processTypeConvert(String fieldType) {
//                        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                        //修改了一下
//                        return getDbColumnType(fieldType);
//                    }
//
//                })
//                .setUrl(dbUrl)
//                .setUsername("aicc")
//                .setPassword("xwyXNlwVflXHl2pyR1SY")
//                .setDriverName("com.mysql.jdbc.Driver");
//
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig
//                // 全局大写命名 ORACLE 注意
//                .setCapitalMode(true)
//                .setDbColumnUnderline(true)
//                .setRestControllerStyle(true)
//                .setEntityLombokModel(true)
//                .setEntityBooleanColumnRemoveIsPrefix(true)
//                .setVersionFieldName("version")
//                .setLogicDeleteFieldName("delete")
//                .setNaming(NamingStrategy.underline_to_camel)
//                // 修改替换成你需要的表名，多个表名传数组
//                .setInclude(tableNames);
//
//        config.setActiveRecord(false)
//                .setAuthor(AUTHOR)
//                .setOpen(false)
//                .setEnableCache(false)
//                .setBaseResultMap(true)
//                .setOutputDir("/Users/liwenxing/Desktop/java")
//                .setFileOverride(true);
//
//        // 注入自定义配置，可以在 VM 中使用 cfg.xxx【可无】
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("author", this.getConfig().getGlobalConfig().getAuthor());
//                this.setMap(map);
//            }
//        };
//
//        new MpGenerator().setGlobalConfig(config)
//                .setDataSource(dataSourceConfig)
//                .setStrategy(strategyConfig)
//                .setCfg(cfg)
//                .setPackageInfo(
//                        new PackageConfig()
//                                .setParent(packageName)
//                                .setController("web.controller")
//                                .setEntity("dal.entity")
//                                .setMapper("dal.dao")
//                                .setService("dal.service")
//                                .setServiceImpl("dal.impl")
//                                .setXml("/resources/mybatis/mapper")
//                ).execute();
//    }
//
//    /**
//     * 重写getDbColumnType方法，返回类型为Date的全部使用java8 的LocalDate
//     *
//     * @param fieldType 字段类型
//     * @return
//     */
//    private static DbColumnType getDbColumnType(String fieldType) {
//        String t = fieldType.toLowerCase();
//        if (!t.contains("char") && !t.contains("text")) {
//            if (t.contains("bigint")) {
//                return DbColumnType.LONG;
//            } else if (t.contains("int")) {
//                return DbColumnType.INTEGER;
//            } else if (!t.contains("date") && !t.contains("time") && !t.contains("year")) {
//                if (t.contains("text")) {
//                    return DbColumnType.STRING;
//                } else if (t.contains("bit")) {
//                    return DbColumnType.BOOLEAN;
//                } else if (t.contains("decimal")) {
//                    return DbColumnType.BIG_DECIMAL;
//                } else if (t.contains("clob")) {
//                    return DbColumnType.CLOB;
//                } else if (t.contains("blob")) {
//                    return DbColumnType.BLOB;
//                } else if (t.contains("binary")) {
//                    return DbColumnType.BYTE_ARRAY;
//                } else if (t.contains("float")) {
//                    return DbColumnType.FLOAT;
//                } else if (t.contains("double")) {
//                    return DbColumnType.DOUBLE;
//                } else {
//                    return DbColumnType.STRING;
//                }
//            } else {
//                return DbColumnType.LOCAL_DATE;
//            }
//        } else {
//            return DbColumnType.STRING;
//        }
//    }
//}
