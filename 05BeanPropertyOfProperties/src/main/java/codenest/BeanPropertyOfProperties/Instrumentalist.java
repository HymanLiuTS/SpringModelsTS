package codenest.BeanPropertyOfProperties;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class Instrumentalist implements Performer {

	public void perform() {
		this.instruments.forEach((k, v) -> {
			System.out.println(k + ":" + v );
		});
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstruments(Properties instruments) {
		this.instruments = instruments;
	}

	private String song;

	private Properties instruments;

}
