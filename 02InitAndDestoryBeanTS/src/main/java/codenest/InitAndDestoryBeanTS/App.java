package codenest.InitAndDestoryBeanTS;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/InitAndDestoryBeanTS/spring-ido1.xml");
		Auditorium auditorium = (Auditorium) ctx.getBean("hyman");
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
