package codenest.ValueTS;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/ValueTS/spring-ido1.xml");
    	Instrmentlist juggler = (Instrmentlist) ctx.getBean("hyman");
		juggler.perform();
    }
}
