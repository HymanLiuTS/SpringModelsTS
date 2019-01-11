package codenest.aopts5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/aopts5/spring-ido1.xml");
		Thinker stage = (Thinker) ctx.getBean("hyman");
		Message message=new Message();
		message.setContent("Hello AOP");
		stage.thinkOfSomething(message);
		Magician magician = (Magician) ctx.getBean("magician");
		System.out.println(magician.getThoughts().getContent());
	}
}
