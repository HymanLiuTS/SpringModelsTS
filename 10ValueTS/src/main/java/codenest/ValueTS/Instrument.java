package codenest.ValueTS;

import org.springframework.beans.factory.annotation.Value;

public class Instrument {

	@Value("DIDI")
	private String sound;

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}
