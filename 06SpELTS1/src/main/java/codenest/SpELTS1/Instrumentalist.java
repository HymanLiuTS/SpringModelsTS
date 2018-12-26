package codenest.SpELTS1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import codenest.SpELTS1.Performer;

public class Instrumentalist implements Performer {

	public void perform() {
		System.out.println("My name is " + this.fullName);
		System.out.println("I,m " + this.age + " years old");
		if (this.isAdult == true)
			System.out.println("I'm a adult");
		else
			System.out.println("I'm a kid");
		if (this.validEmail)
			System.out.println("My email is " + this.email);
		else
			System.out.println("I have no email");
	}

	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(Boolean isAdult) {
		this.isAdult = isAdult;
	}

	private Boolean isAdult = false;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(Boolean validEmail) {
		this.validEmail = validEmail;
	}

	private int age;

	private String email;

	private Boolean validEmail = false;

}
