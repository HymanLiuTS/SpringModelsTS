package codenest.SpEL2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/SpEL2/spring-ido1.xml");
    	Instrumentalist juggler = (Instrumentalist) ctx.getBean("hyman");
		juggler.perform();
    }
}
