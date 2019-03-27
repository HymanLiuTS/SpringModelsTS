package springmvcdemo.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springmvcdemo.authentication.AuthUserPrincipal;
import springmvcdemo.authentication.model.User;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userService")
    private UserService userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AuthUserPrincipal(user);
	}

}