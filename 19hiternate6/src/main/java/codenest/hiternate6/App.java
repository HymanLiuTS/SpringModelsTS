package codenest.hiternate6;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import codenest.hiternate6.domain.Student;
import codenest.hiternate6.domain.Teacher;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// 默认从classpath下加载配置文件
		Configuration config = new Configuration();
		config = config.configure("/codenest/hiternate6/hibernate.cfg.xml");

		// 创建会话工厂对象，,hibernate4.35之后的方式
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 创建会话对象
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();
		HashSet students = new HashSet(0);
		HashSet teachers = new HashSet(0);

		Student stu1 = new Student();
		stu1.setName("stu1");
		stu1.setAge(18);
		Student stu2 = new Student();
		stu2.setName("stu2");
		stu2.setAge(19);
		students.add(stu1);
		students.add(stu2);

		Teacher tea1 = new Teacher();
		tea1.setName("tea1");
		tea1.setEmail("123@456.com");
		Teacher tea2 = new Teacher();
		tea2.setName("tea2");
		tea2.setEmail("123567@456.com");
		teachers.add(tea1);
		teachers.add(tea2);

		stu1.setTeachers(teachers);
		stu2.setTeachers(teachers);
		tea1.setStudents(students);
		tea2.setStudents(students);
		session.save(stu1);
		session.save(stu2);
		session.save(tea1);
		session.save(tea2);

		transaction.commit();
		transaction = session.beginTransaction();
		stu1=session.get(Student.class,3);
		session.delete(stu1);
		transaction.commit();
		
		session.close();
	}
}
