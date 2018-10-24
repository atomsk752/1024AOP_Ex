package org.atomsk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class NullAdvice {
	@Around("execution(* org.atomsk.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		log.info("checkNull...................");
		log.info("checkNull...................");		
		log.info("checkNull...................");
		Object result =null;
		
		//null체크를 하면 create를 할때 null 있는 경우 메소드 실행을 막는다  또는 시간값 들어갈 때
		try {
			
			boolean checkNull = false;
			Object[] params = pjp.getArgs();
			for (Object object : params) {
				if (object==null) {
					throw new Exception("Null");
					
				}
			}
			 result = pjp.proceed();//얘가 메소드 실행 invoke
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
