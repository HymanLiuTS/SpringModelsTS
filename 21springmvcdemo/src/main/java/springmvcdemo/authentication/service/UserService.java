package springmvcdemo.authentication.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvcdemo.authentication.dao.UserDao;
import springmvcdemo.authentication.model.Group;
import springmvcdemo.authentication.model.GroupUserMap;
import springmvcdemo.authentication.model.User;
import springmvcdemo.common.repository.GroupRepository;
import springmvcdemo.common.repository.GroupUserMapRepository;
import springmvcdemo.common.repository.UserRepository;

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
		return userRepository.findByUsername(userName);
	}

	@Transactional
	public User save(User user) {
		user.setEnabled(true);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Transactional
	public GroupUserMap putUserToGroup(String userName,String groupName) throws Exception{
		User user=userRepository.findByUsername(userName);
		if(user==null)
			throw new Exception("找不到该用户");
		Group group=groupRepository.findByGroupnameEquals(groupName);
		if(group==null)
			throw new Exception("找不到该用户组");
		
		GroupUserMap map=new GroupUserMap(group.getId().longValue(),user.getId().longValue());
		return groupUserMapRepository.save(map);
	}
	
	@Transactional
	public List<String> findAllAuthorities(Integer id){
		return (List<String>) userRepository.findAllAuthorities(id);
	}

}
