package codenest.AOPTs2;

public class Magician implements MindReader {

	private String thoughts;

	public void interceptThoughts(Message message) {
		System.out.println("Intercepting volunteer's thoughts");
		this.thoughts = message.getContent();
	}

	public String getThoughts() {
		return this.thoughts;
	}

}
