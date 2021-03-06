package codenest.hiternate6.domain;

import java.util.HashSet;
import java.util.Set;

// Generated 2019-1-29 9:04:49 by Hibernate Tools 5.3.0.Beta2

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	private int id;
	private String name;
	private Integer age;
	private Set teachers = new HashSet(0);

	public Student() {
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(int id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set getTeachers() {
		return teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}
