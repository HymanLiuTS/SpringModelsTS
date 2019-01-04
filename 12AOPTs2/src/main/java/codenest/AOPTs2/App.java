package codenest.AOPTs2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/AOPTs2/spring-ido1.xml");
		Thinker stage = (Thinker) ctx.getBean("hyman");
		stage.thinkOfSomething("Hello AOP");
		Magician magician = (Magician) ctx.getBean("magician");
		System.out.println(magician.getThoughts());
	}
}
