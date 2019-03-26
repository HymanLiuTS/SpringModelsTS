package springmvcdemo.authentication.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvcdemo.authentication.dao.UserDao;
import springmvcdemo.authentication.model.User;

@Transactional
@Service("userService")
public class UserService{

	@Autowired
	@Qualifier("userDaoImpl")
    private UserDao userDao;

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		 return userDao.findAllUsers();
	}
	
	public User findByUsername(String userName) {
		return userDao.findByUsername(userName);
	}

}
