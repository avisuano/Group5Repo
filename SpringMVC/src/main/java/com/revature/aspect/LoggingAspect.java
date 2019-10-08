package com.revature.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 *This says we are using the classes as an aspect, which will handle cross-cutting
 *concerns. Like this will be for handling logging.
 *
 *We have to use component for it to play with the Spring framework, because
 *@Aspect is not a Sprint stereotype
 */
@Aspect
@Component
public class LoggingAspect {

	//private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);

//	/*
//	 * The pointcut expression points to where are advice should be injected. 
//	 * When anything public returnType name (any # of parameters), this point cut 
//	 * will have advice injected before all methods that are public are executed.
//	 */
//	@Pointcut("execution(public * *(..))")
//	public void allMethodsPointcut() {}
//	
//	@Pointcut("within(com.revature.service..*)")
//	public void inServiceLayer() {}
	
	// Here we are reusing a pointcut that already exists
//	@Before("allMethodsPointcut()")
//	public void logBefore(JoinPoint jp) {
//		LOG.info("The " + jp.getSignature().getName() + ", method is going to be called now.");
//	}
//	
	// This would log something after the method is called, before it returns
	//@After("inServiceLayer()")
	//public void logAfter(JoinPoint jp) {}
	
	// Logs something after method is called, in our inServiceLayer Pointcut returns a value
//	@AfterReturning(pointcut="inServiceLayer()", returning="returnedObject" )
//	public void logAfterReturning(JoinPoint jp, Object returnedObject) {
//		LOG.info("The " + jp.getSignature().getName() + ", method just returned: " + returnedObject);
//	}
	
	// Logs after the methods in our inServiceLayer throws an exception
//	@AfterThrowing(pointcut="inServiceLayer()", throwing="exceptionThrown")
//	public void logAfterThrowing(JoinPoint jp, Exception exceptionThrown) {
//		LOG.info("The " + jp.getSignature().getName() + ", method just threw an " + exceptionThrown);
//	}
	
	// Access to special join point called ProceedingJoinPoint, use sparingly
//	@Around(value="inServiceLayer()")
//	public  void aroundAdvice(ProceedingJoinPoint jp) {
//		try {
//			// This method will skip the next advice or method invocation. Expensive.
//			// Object o = jp.proceed();
//			LOG.info("This is Around Advice for any method the service layer.");
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
