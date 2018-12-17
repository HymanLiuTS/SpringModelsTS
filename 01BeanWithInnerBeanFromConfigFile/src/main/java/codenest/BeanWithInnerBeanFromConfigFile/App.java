package codenest.BeanWithInnerBeanFromConfigFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import codenest.BeanWithInnerBeanFromConfigFile.Performer;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/BeanWithInnerBeanFromConfigFile/spring-ido1.xml");
		Performer juggler = (Performer) ctx.getBean("hyman");
		juggler.perform();
	}
}
