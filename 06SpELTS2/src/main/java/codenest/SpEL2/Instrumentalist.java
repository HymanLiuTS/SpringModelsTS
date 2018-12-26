package codenest.SpEL2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

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
		System.out.println("I live in " + this.city.getName());
		System.out.println("My driver is " + this.driver);
		
		Arrays.stream(this.cityNames).forEach(System.out::println);
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String[] getCityNames() {
		return cityNames;
	}

	public void setCityNames(String[] cityNames) {
		this.cityNames = cityNames;
	}

	private int age;

	private String email;

	private Boolean validEmail = false;

	private City city;
	
	private String driver;
	
	private String[] cityNames;

}
