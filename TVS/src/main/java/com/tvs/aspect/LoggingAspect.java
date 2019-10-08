//package com.tvs.aspect;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
//	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
//	
//	@Pointcut("execution(public * *(..))")
//	public void allMethodsPointCut() {}
//	
//	@Pointcut("within(com.tvs.service..*)")
//	public void inServiceLayer() {}
//	
//	/*
//	 * We reuse a Pointcut that already exists here. We don't have to, but it's
//	 * efficient.
//	 */
//	
//	//This would log something after the methods targeted in our inServiceLayer Pointcut
//	@After("inServiceLayer()")
//	public void logAfter(JoinPoint jp) {}
//	
//	
//}
