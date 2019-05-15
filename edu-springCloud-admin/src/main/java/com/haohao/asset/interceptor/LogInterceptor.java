package com.haohao.asset.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.haohao.asset.utils.SessionUtil;

public class LogInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String url = SessionUtil.getRequestURL();
        SessionUtil.setAttribute(url, System.currentTimeMillis());
        String ip = SessionUtil.getRemoteAddr();
        String prams = SessionUtil.getPrams();
        String realName = "";
        if (SessionUtil.isLogin()) {
            realName = SessionUtil.getRealName();
        }
        log.info("日志==>用户:" + realName + "[" + ip + "]" + "访问:" + url + prams);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = SessionUtil.getRequestURL();
        if (null != SessionUtil.getAttribute(url)) {
            long executeTime = System.currentTimeMillis() - (long) SessionUtil.getAttribute(url);
            if (executeTime > 2000) {
                log.info("日志==>访问:" + url + "耗时:" + executeTime);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
