package kosta.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(2)
public class SampleAdvice {

	/**
	 * before: 사전처리
	 * */
	@Before("PointCutClass.pointCut()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object params [] = joinPoint.getArgs(); // params 안에 들고 들어오는 매개변수의 값들이 저장된다.
		System.out.println(methodName + "의 인수의 개수: " + params.length);
		for(Object o : params) {
			System.out.println(methodName + "의 인수의 값: " + o);
		}
		System.out.println(methodName + " 호출되기 전 before \n");
	}
	
	/**
	 * after: 예외가 발생하든 안하든 무조건 사후처리
	 * */
	@After("PointCutClass.pointCut()")
	public void afterFinally() {
		System.out.println("afterFinally() 예외 발생여부 상관없이 호출됩니다.");
	}
	
	/**
	 * after-returning: 예외가 없이 정상적으로 동작했을 때 사후처리
	 * */
	@AfterReturning(pointcut="PointCutClass.pointCut()", returning = "obj")
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + "의 리턴값: " + obj);
		System.out.println("afterReturning()--정상동작 사후 처리입니다.");
	}
	
	/**
	 * after-throwing: 예외가 발생했을 때 사후처리
	 * */
	@AfterThrowing(pointcut="PointCutClass.pointCut()", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("afterThrowing 예외가 발생한 후 처리. / e: " + e + "\n");
	}
}
