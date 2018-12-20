package codenest.BeanPropertyOfCollection;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/BeanPropertyOfCollection/spring-ido1.xml");
		Performer juggler = (Performer) ctx.getBean("hyman");
		juggler.perform();
    }
}
