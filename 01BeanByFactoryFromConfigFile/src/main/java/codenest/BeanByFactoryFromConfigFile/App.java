package codenest.BeanByFactoryFromConfigFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.codenest.springmodelsts.BeadFromConfigFile.Performer;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/BeanByFactoryFromConfigFile/spring-ido1.xml");
		Stage stage = (Stage) ctx.getBean("hyman");
		stage.perform();
	}
}
