package springmvcdemo.authentication.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvcdemo.authentication.dao.UserDao;
import springmvcdemo.authentication.model.User;
import springmvcdemo.common.repository.GroupRepository;
import springmvcdemo.common.repository.GroupUserMapRepository;
import springmvcdemo.common.repository.UserRepository;

@Transactional
@Service("userService")
public class UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("groupRepository")
	private GroupRepository groupRepository;
	
	@Autowired
	@Qualifier("groupUserMapRepository")
	private GroupUserMapRepository groupUserMapRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User findByUsername(String userName) {
		return userDao.findByUsername(userName);
	}

	@Transactional
	public User addUser(User user) {
		user.setEnabled(true);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

}
