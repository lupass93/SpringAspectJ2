package org.school.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * Logging Aspect for log execution of Controller, Repository and other Components
 * 
 * @author lupass93
 *
 */
@Aspect
@Component
public final class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	/**
	 * 
	 * Pointcut that match the necessary component
	 * 
	 */
	@Pointcut("within(org.school.abstraction..*)")
	public void applicationPackagePointcut() {
	}
	
	@Before("applicationPackagePointcut()") 
	public void logBefore(JoinPoint joinPoint) {
		
		log.info("Enter in Class: "+joinPoint.getClass().getName()+ " in method "+joinPoint.getSignature().getName()+ " with "+joinPoint.getSignature().getDeclaringTypeName()+" with arguments "+Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterThrowing(pointcut="applicationPackagePointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		
		log.debug("Exit from: "+joinPoint.getClass().getName()+" method: "+joinPoint.getSignature().getName()+" with: "+joinPoint.getSignature().getDeclaringTypeName()+" with arguments: "+Arrays.toString(joinPoint.getArgs())+" with cause: "+e.getCause());
		
		
	}
	
	@AfterReturning(pointcut = "applicationPackagePointcut()", returning="retVal")
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		
		log.info("Exit from "+joinPoint.getClass().getName()+ "in method "+joinPoint.getSignature().getName()+" with "+ joinPoint.getSignature().getDeclaringTypeName()+" with arguments "+Arrays.toString(joinPoint.getArgs())+" with result "+retVal);
		
	}
	
	
	

}
