package codenest.AOPTs3;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/AOPTs3/spring-ido1.xml");
		Dancer dancer = (Dancer) ctx.getBean("hyman");
		dancer.dance();
    }
}
