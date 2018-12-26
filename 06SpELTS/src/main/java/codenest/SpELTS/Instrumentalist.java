package codenest.SpELTS;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Instrumentalist implements Performer {

	public void perform() {
		this.instruments.forEach((k, v) -> {
			System.out.println(k + ":");
			v.play();
		});
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstruments(HashMap<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String song;

	private HashMap<String, Instrument> instruments;

	private String message;

	private double age;

	public void show() {
		System.out.println(this.message + ",I'm " + this.age + " years old" + ", I like sing " + this.song);
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

}
