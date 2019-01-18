package codenest.hiberatets;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("codenest/hiberatets/BeanLocations.xml");
    	SpitterDao stage = (SpitterDao) ctx.getBean("spitterDaoImpl");
    	Spitter spitter=new Spitter();
    	spitter.setId(123);
    	spitter.setName("tom");
    	spitter.setEmail("12@qq.com");
    	stage.save(spitter);
    	ctx.close();
    }
}
