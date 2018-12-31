package codenest.ValueTS;

import org.springframework.beans.factory.annotation.Value;

public class Instrmentlist {

	@Value("5")
	private int max;

	@Value("#{instrument.sound}")
	private String sound;

	public void perform() {
		for (int i = 0; i < this.max; i++) {
			System.out.println(this.sound);
		}
	}
}
