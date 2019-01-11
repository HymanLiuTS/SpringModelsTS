package codenest.aopts6;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/aopts6/spring-ido1.xml");
		Dancer dancer = (Dancer) ctx.getBean("hyman");
		dancer.dance();
    }
}
