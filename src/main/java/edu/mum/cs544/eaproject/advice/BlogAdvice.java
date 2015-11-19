/**
 * 
 */
package edu.mum.cs544.eaproject.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author baopham
 *
 */

@Aspect
@Component
public class BlogAdvice {

	private static Logger logger = Logger.getLogger(BlogAdvice.class);
	
	@Before("execution(* edu.mum.cs544.eaproject.service.*.*(..))")
	public void beforeTraceMethod(JoinPoint joinpoint) {
		logger.info("Before executing " + joinpoint.getSignature().getName());
	}
	
	@After("execution(* edu.mum.cs544.eaproject.service.*.*(..))")
	public void afterTraceMethod(JoinPoint joinpoint) {
		logger.info("After executing " + joinpoint.getSignature().getName());
	}
}
