package codenest.AOPTs2;

import org.springframework.stereotype.Component;

@Component("hyman")
public class Volunteer implements Thinker {

	private String thoughts;

	public void thinkOfSomething(String thoughts) {
		this.thoughts = thoughts;
	}

	public String getThoughts() {
		return this.thoughts;
	}

}
