package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(1)
public class AroundAdvice {
	
	/**
	 * 사전, 사후 처리
	 * @param : ProceedingJoinPoint
	 * @return : Object
	 * */
	@Around("PointCutClass.pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		// 사전처리
		System.out.println("around의 사전 처리 중입니다.\n");
		
		Object obj = joinPoint.proceed();
		
		// 사후처리
		System.out.println("around의 사후 처리 중입니다.\n");
		
		return obj;
	}

}
