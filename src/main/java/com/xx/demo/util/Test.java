package com.xx.demo.util;


import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * @author mingfu
 * @date 2021/12/21
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now ().toInstant(ZoneOffset.UTC).toEpochMilli() % (24 * 60 * 60 * 1000) );
        System.out.println(12 * 60 * 60 * 1000);
    }


}
