package springmvcdemo.authentication.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springmvcdemo.authentication.model.User;
import springmvcdemo.common.domain.ControllerBaseTest;

public class UserRepositoryTest extends ControllerBaseTest {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Test
	public void findByUsernameTest() {
		User user = userRepository.findByUsername("admin");
		assertTrue(user!=null);
		assertEquals(user.getUsername(),"admin");
	}

}
