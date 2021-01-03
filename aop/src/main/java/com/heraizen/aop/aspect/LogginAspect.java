package com.heraizen.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.heraizen.aop.service.ArithMeticOperation.*(..))")
	public void beforeAdvice(JoinPoint join)
	{
		log.info("{}",join.getSignature());
	}
	
	@After("execution(* com.heraizen.aop.service.ArithMeticOperation.*(..))")
	public void AfterAdvice(JoinPoint join)
	{
		log.info("{}",join.getSignature());
	}
	
	@Around("execution(* com.heraizen.aop.service.ArithMeticOperation.*(..))")
	public Object aroundArithmeticAdivce(ProceedingJoinPoint join)
	{
		
		log.info("The method : {} is called with arg  {}",join.getSignature().getName(),Arrays.toString(join.getArgs()));
		
		Object obj = null;
		
		try {
			
			log.info("The method : {} is called with arg  {}",join.getSignature().
					getName(),Arrays.toString(join.getArgs()));
			
			 obj = join.proceed();
		
		}
		catch(Throwable e)
		{
			System.out.println(e);
		}
		
		return obj;
		
	}
	
}
