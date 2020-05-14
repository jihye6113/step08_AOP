package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * AOP 적용 대상에 대한 PointCut 정의 클래스
 * */
public class PointCutClass {

	/**
	 * 로그 처리
	 * */
	@Pointcut("execution(public * kosta.service.*Impl.*(..))")
	public void pointCut() {}
	
	/**
	 * 트랜잭션 처리
	 * */
	
	/**
	 * 세션유무 체크
	 * */
}
