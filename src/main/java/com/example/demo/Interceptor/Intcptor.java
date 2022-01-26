package com.example.demo.Interceptor;


import com.example.demo.controller.rest;
import com.example.demo.service.IPUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Intcptor implements HandlerInterceptor {
//    @Autowired
//    ActiveObjectFactory activeObjectFactory;
    private static final Log logger = LogFactory.getLog(Intcptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String ip= IPUtils.getIpAddr(request);
        String uri=request.getRequestURI();
        String userAgent=request.getHeader("User-Agent");
//        String ua=request.getHeader("sec-ch-ua");
        logger.info("userAgent:"+userAgent);
        logger.info("ip:"+ip+"         uri:"+uri);
        return true;
    }
    // 在业务处理器处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception{
    }
    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception{
    }
}
