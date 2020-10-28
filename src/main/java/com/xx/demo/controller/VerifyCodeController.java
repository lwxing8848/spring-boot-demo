package com.xx.demo.controller;

import com.xx.demo.common.VersionConstant;
import com.xx.demo.util.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lwx
 */
@Slf4j
@RestController
@RequestMapping(VersionConstant.V1 + "/verifyCode")
public class VerifyCodeController {


    /**
     *  获取验证码图片
     */
    @GetMapping("/getVerifyCodeImg")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            VerifyCodeUtil.getVerifyCode(request, response);
        } catch (Exception e) {
            log.error("生成验证码失败", e);
        }
    }


}
