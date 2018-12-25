package codenest.BeanPropertyOfMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Instrumentalist implements Performer {

	public void perform() {
		this.instruments.forEach((k, v) -> {
			System.out.println(k + ":" );
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

	private String song;

	private HashMap<String, Instrument> instruments;

}
