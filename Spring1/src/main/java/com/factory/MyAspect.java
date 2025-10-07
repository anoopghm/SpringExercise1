package com.factory;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final String CLASS_NAME=MyAspect.class.getName();
	private static Logger logger=Logger.getLogger(CLASS_NAME);
	
	@Before("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public void welcome() {
		logger.entering(CLASS_NAME, "entering sell shoe method...");
		System.out.println("Welcom to shoe shop.....");
	}
	
	@AfterReturning("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public void thankyou() {
		logger.info("sell shoe method finished and now it will exit...");
		System.out.println("Thank you.....For purchase..come again....");
	}
	@Around("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public Object duringPurchase(ProceedingJoinPoint jointpoint) throws Throwable{
		logger.info("now the sell shoe method is getting executed.....");
		System.out.println("during the execution of sell shoe method...");
		long startTime = System.currentTimeMillis();
		Shoe shoe=(Shoe)jointpoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("the return value of sell shoe logic is...:"+shoe);
		logger.info("Time taken for execution of the function " + (endTime-startTime) );
		return shoe;
	}
	
	@AfterThrowing(pointcut = "execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public void handleException(MyCustomException e) {
		System.out.println("Exception handling code is written here...");
	}
}