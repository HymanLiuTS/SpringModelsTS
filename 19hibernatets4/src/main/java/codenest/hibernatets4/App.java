package codenest.hibernatets4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import codenest.hibernatets4.model.BoUniconfigInfo;
import codenest.hibernatets4.model.Spitter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		// 默认从classpath下加载配置文件
		Configuration config = new Configuration();
		config = config.configure("/codenest/hibernatets4/resources/hibernate.cfg.xml");
		InputStream in = App.class.getClassLoader().getResourceAsStream("codenest/hibernatets4/resources/hibernate.properties");
		Properties properties = new Properties();
		properties.load(in);
		config.setProperties(properties);
		
		Configuration config2 = new Configuration();
		config2 = config2.configure("/codenest/hibernatets4/resources/hibernate.cfg2.xml");
		
		// 以addClass的方式加载配置文件
		// Configuration config = new Configuration().addClass(Spitter.class);
		// 创建服务注册对象,hibernate4.35之前的方式
		// StandardServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder()
		// .applySettings(config.getProperties()).build();
		// 创建会话工厂对象，,hibernate4.35之后的方式
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 创建会话对象
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();

		Spitter spiiter = new Spitter();
		spiiter.setName("hyman2");
		spiiter.setEmail("123@345.com");
		session.save(spiiter);
		transaction.commit();
		session.close();
		
		SessionFactory sessionFactory2 = config2.buildSessionFactory();
		// 创建会话对象
		Session session2 = sessionFactory2.openSession();
		// 开启事务
		Transaction transaction2 = session2.beginTransaction();

		BoUniconfigInfo boUniconfigInfo = new BoUniconfigInfo();
		boUniconfigInfo.setClassid(1);
		boUniconfigInfo.setExt("{}");
		boUniconfigInfo.setLogtime(new Date());
		boUniconfigInfo.setModifytime(new Date());
		session2.save(boUniconfigInfo);
		transaction2.commit();
		session2.close();
	}
}
