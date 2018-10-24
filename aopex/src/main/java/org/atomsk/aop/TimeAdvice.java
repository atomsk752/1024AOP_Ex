package org.atomsk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class TimeAdvice {


	@Around("execution(* org.atomsk.service.*.*(..))") //서비스에 있는 모든 메서드의 시간을 체크
	//@Around("execution(* org.atomsk.service.SampleService*.*(..))") //서비스에 있는 모든 메서드의 시간을 체크
	public Object checkTime(ProceedingJoinPoint pjp) { //시간을 체크하는게 튜닝의 기본, 메소드 마다 다 넣는것보다 이게 훨씬 빠름!
		
		Object result = null;
		
		try {
			long start = System.currentTimeMillis();
			
			result = pjp.proceed();
		
			long end = System.currentTimeMillis();
			log.info("TOTAL: " + (end - start));
			
			return result;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
