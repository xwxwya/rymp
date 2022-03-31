package com.ruoyi.common.aspect;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.serializetion.ControllerSerializeAdviceFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xw
 * date:2021-10-19
 * 切面
 */
@Aspect
@Component
public class SystemAdvice {

    @Resource
    private ControllerSerializeAdviceFilter serializeAdviceFilter;

    static {
        // load license infomation
        System.out.println(BaseController.class + " loaded");
    }

    {
        System.out.println(getClass() + " inited");
    }

    @Around("webRequest()")
    public Object aroundWebRequest(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = serializeAdviceFilter.doAround(pjp);
        return obj;
    }

    @Pointcut("execution(* com.*.web.controller..*.*(..))")
    public void webRequest() {
        System.out.println("web request");
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

}
