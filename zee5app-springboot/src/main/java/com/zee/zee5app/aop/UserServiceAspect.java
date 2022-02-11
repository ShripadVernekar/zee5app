package com.zee.zee5app.aop;

//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect // container where u will hold your app code
public class UserServiceAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.stereotype.Repository *) "
			+ "|| within(@org.springframework.stereotype.Service *) "
			+ "|| within(@org.springframework.web.bind.annotation.RestController *)")

	public void springPointCutExp() {

	}
	
	@Pointcut("within(com.zee.zee5app.controller..*) "
			+ "|| within(com.zee.zee5app.service.impl..*) ")
	public void springPointCutExp2() {

	}

	// for logging purpose
	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
	public void logAfterThrowingException(JoinPoint joinpoint, Throwable e) {
		
		log.error("exception {}.{}() with cause {}", joinpoint.getSignature().getDeclaringTypeName(),
													 joinpoint.getSignature().getName(), 
													 e.getCause() != null ? e.getCause() : "NULL");
	}

	@Before(value = "execution(* com.zee.zee5app.service.impl.*.*(..))")
	private void beforeAllServieMethods(JoinPoint joinpoint) {

		System.out.println(joinpoint);
		System.out.println("hello");
	}
	
//	@Around("beforeAllServieMethods()")
//	public void aroundEx() {
//		System.out.println("Hello from around");
//	}
	
}
