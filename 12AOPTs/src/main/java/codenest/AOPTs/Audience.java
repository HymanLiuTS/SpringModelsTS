package codenest.AOPTs;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void takeSeats() {
		System.out.println("the audience is taking their seats");
	}

	public void takeOffCellPhones() {
		System.out.println("the audience is turning Off their cellphones");
	}

	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP");
	}

	public void demandRefund() {
		System.out.println("We want our money back");
	}

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
