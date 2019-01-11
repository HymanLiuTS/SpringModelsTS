package codenest.aopts4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

	@Pointcut("execution(* codenest.aopts4.Performer.perform(..))")
	public void performance() {

	}

	@Before("performance()")
	public void takeSeats() {
		System.out.println("the audience is taking their seats");
	}

	@Before("performance()")
	public void takeOffCellPhones() {
		System.out.println("the audience is turning Off their cellphones");
	}

	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("We want our money back");
	}

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinPoint) {

		try {
			System.out.println("the audience is taking their seats");
			System.out.println("the audience is turning Off their cellphones");
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("CLAP CLAP CLAP CLAP");
			System.out.println("The performence took " + (end - start) + " millionseconds");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("We want our money back");
		}

	}

}
