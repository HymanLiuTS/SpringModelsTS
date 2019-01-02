package codenest.ScanTS;

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
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/ScanTS/spring-ido1.xml");
    	Instruclist juggler = (Instruclist) ctx.getBean("instruclist");
		juggler.perform();
    }
}
