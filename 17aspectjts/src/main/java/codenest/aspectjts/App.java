package codenest.aspectjts;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/aspectjts/spring-ido1.xml");
		Performer stage = (Performer) ctx.getBean("hyman");
		stage.perform();
    }
}
