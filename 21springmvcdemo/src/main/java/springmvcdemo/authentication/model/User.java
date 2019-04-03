package springmvcdemo.authentication.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String authorities;

	private Boolean enabled;

	private String password;

	private String username;

	public User() {
	}

	public User(Integer id, String username, String password, String authorities, Boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.enabled = enabled;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}