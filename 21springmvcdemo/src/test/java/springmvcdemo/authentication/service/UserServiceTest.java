package springmvcdemo.authentication.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springmvcdemo.authentication.model.User;
import springmvcdemo.common.domain.ControllerBaseTest;

public class UserServiceTest extends ControllerBaseTest{
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Test
	public void findAllUsersTest() {
		List<User> users=userService.findAllUsers();
		assertTrue(users!=null);
		assertFalse(users.isEmpty());
	}
}
