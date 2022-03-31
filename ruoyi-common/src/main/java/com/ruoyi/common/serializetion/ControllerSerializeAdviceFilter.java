package com.ruoyi.common.serializetion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
/**
 *
 * @author xw
 * date:2021-10-19
 * Spring Controller 序列化拦截器
 */
@Component
public class ControllerSerializeAdviceFilter extends ControllerSerializeSupport {
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = pjp.proceed();
		MethodSignature msig = (MethodSignature) pjp.getSignature();
		return doAround(obj, msig.getMethod());
	}
    

}
