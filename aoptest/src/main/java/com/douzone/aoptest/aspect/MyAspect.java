package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))") //
	public void beforeAdvice() {
		System.out.println("----- before Advice -----");
	}
	
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("----- after Advice -----");
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("----- afterReturning Advice -----");
	}
	
	@Around("execution(* *..*.service.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		//before advice
		System.out.println("@Around(bofere) Advice");
		
		
		// PointCut Method 실행
		
		// Object[] params = {"Camera"}; //원래 호출은 tv로 하려 했는데 camera로 파라미터 가로채기(바꾸기)
		//Object result = pjp.proceed(params);
		
		Object result = pjp.proceed(); //파라미터 없이 실행
		
		
		
		//after advice
		System.out.println("@Around(after) Advice");
		
		return result;
	}
	
	public void arountAdvice() {
		
	}
}
