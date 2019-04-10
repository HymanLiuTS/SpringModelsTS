package springmvcdemo.authentication.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import springmvcdemo.authentication.model.User;
import springmvcdemo.common.domain.WebAppContextBaseTest;

public class UserRepositoryTest extends WebAppContextBaseTest {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("cacheManager")
	private CacheManager cacheManager;


	@Test
	public void findByUsernameTest() {
		User user = userRepository.findByUsername("admin");
		assertTrue(user != null);
		assertEquals(user.getUsername(), "admin");
	}

	@Test
	public void findAllAuthoritiesTest() {
		Cache cache=cacheManager.getCache("sampleCache1");
		String name=cache.getName();
		Optional<User> user1 = userRepository.findById((long) 1);
		Optional<User> user2 = userRepository.findById((long) 1);
		assertTrue(user1 != null);
		assertTrue(user2 != null);
	}

}
