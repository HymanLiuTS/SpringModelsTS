package codenest.BeanPropertyOfCollection;

import java.util.Collection;
import java.util.Collections;

public class Instrumentalist implements Performer {

	public void perform() {
		System.out.print("Playiing " + this.song + " :");
		this.instruments.forEach((instrument)->instrument.play());
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	private String song;

	private Collection<Instrument> instruments;

}
