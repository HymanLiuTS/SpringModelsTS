package codenest.hibernatets4.model;
// Generated 2019-1-28 10:59:08 by Hibernate Tools 5.3.0.Beta2

/**
 * Spitter generated by hbm2java
 */
public class Spitter implements java.io.Serializable {

	private int id;
	private String name;
	private String email;

	public Spitter() {
	}

	public Spitter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Spitter(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
