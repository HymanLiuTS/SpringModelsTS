package codenest.hibernate5;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import codenest.hibernate5.domain.Customer;
import codenest.hibernate5.domain.Myorder;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// 默认从classpath下加载配置文件
		Configuration config = new Configuration();
		config = config.configure("/codenest/hibernate5/hibernate.cfg.xml");
		
		// 创建会话工厂对象，,hibernate4.35之后的方式
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 创建会话对象
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer();
		customer.setName("hyman");
		customer.setEmail("12@qq.com");
		
		Set myorders = new HashSet(0);
		Myorder myorder=new Myorder();
		myorder.setCustomer(customer);
		myorder.setMoney(6.0);
		myorder.setOrdernum("123456789");
		myorder.setCustomer(customer);
		myorders.add(myorder);
		
		Myorder myorder1=new Myorder();
		myorder1.setCustomer(customer);
		myorder1.setMoney(1.0);
		myorder1.setOrdernum("qwertyuiop");
		myorder1.setCustomer(customer);
		myorders.add(myorder1);
		
		customer.setMyorders(myorders);
		
		session.save(customer);
		session.save(myorder);
		session.save(myorder1);
		
		transaction.commit();
		session.close();
	}
}
