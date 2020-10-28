package com.xx.demo.util;

import java.util.UUID;

/**
 * 通用工具类
 * @author lwx
 */
public class CommonUtils {

    public static String getUuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
