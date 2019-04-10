package springmvcdemo.authentication.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import springmvcdemo.authentication.model.User;
import springmvcdemo.common.domain.WebAppContextBaseTest;

public class UserServiceTest extends WebAppContextBaseTest{
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//通过PersistenceContext获取的是试题管理类对象
	@PersistenceContext(unitName="authEntityManagerFactory")
	EntityManager em2;
	
	@Autowired
	@Qualifier("authEntityManagerFactory")
	private EntityManagerFactory emf;

	@Test
	public void findAllUsersTest() {
		List<User> users=userService.findAllUsers();
		assertTrue(users!=null);
		assertFalse(users.isEmpty());
	}
	
	/**
	 * 一级缓存测试
	 */
	@Test
	public void findUsersByIDTest() {
		//一级缓存只针对同一个EntityManager有效，为session级别的缓存，一个EntityManager创建后开启一个session
		EntityManager em=emf.createEntityManager();
		User user1=em.find(User.class, 1);
		User user2=em.find(User.class, 1);
		assertEquals(user1.getUsername(),user1.getUsername());
	}
}
