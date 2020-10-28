package com.xx.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwx
 * @date 2020/9/18
 */
public class MatcherUtils {

    /**手机号正则*/
    private static Pattern phoneMatcher = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    /**邮箱正则*/
    private static Pattern emailMatcher = Pattern.compile("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$");

    public static boolean isMobileNO(String mobiles){
        Matcher m = phoneMatcher.matcher(mobiles);
        return m.matches();
    }

    public static boolean isEmailAddress(String email){
        Matcher m = emailMatcher.matcher(email);
        return m.matches();
    }

}
