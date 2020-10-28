package com.xx.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 * @author Lwx
 */
@Slf4j
public class Authentication implements HandlerInterceptor {


    public Authentication() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        log.error("Session expiration 会话已过期，请重新登陆, 访问地址:{}", path);
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.setStatus(401);
        response.sendError(401,"会话已过期，请重新登陆");
        return false;
    }
}
