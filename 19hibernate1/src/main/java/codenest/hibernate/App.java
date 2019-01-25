package codenest.hibernate;

import org.hibernate.Transaction;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import codenest.hiberatets.dao.SpitterDao;
import codenest.hiberatets.model.Spitter;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/hiberatets/resources/BeanLocations.xml");
		SpitterDao stage = (SpitterDao) ctx.getBean("spitterDaoImpl");
		stage.openSession();
		Transaction ts = null;
		try {
			ts = stage.beginTransaction();
			Spitter spitter = new Spitter();
			spitter.setName("tom");
			spitter.setEmail("12@qq.com");
			stage.save(spitter);
			spitter = stage.findByID(79193);
			System.out.println(spitter.toString());

			spitter.setEmail("hyman@codenest.cn");
			stage.update(spitter);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		} finally {
			stage.closeSession();
			ctx.close();
		}
	}
}
