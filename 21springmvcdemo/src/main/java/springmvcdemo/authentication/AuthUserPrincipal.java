package springmvcdemo.authentication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import springmvcdemo.authentication.model.User;

public class AuthUserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1026882722639048927L;
	private User user;

	public AuthUserPrincipal(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<AuthGrantedAuthority> list=new ArrayList<AuthGrantedAuthority>();
		String authorities = this.user.getRole();
		if (authorities != null && authorities.isEmpty() == false) {
			String[] auths = authorities.split(",");
			for(int i=0;i<auths.length;i++){
				list.add(new AuthGrantedAuthority(auths[i]));
			}
		}
		return list;
	}

	public String getPassword() {
		return this.user.getPassword();
	}

	public String getUsername() {
		return this.user.getUsername();
	}

	public boolean isEnabled() {
		return this.user.getEnabled();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}
