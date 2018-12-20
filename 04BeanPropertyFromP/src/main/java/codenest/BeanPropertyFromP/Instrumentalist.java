package codenest.BeanPropertyFromP;

public class Instrumentalist implements Performer {

	public void perform() {
		System.out.print("Playiing " + this.song + " :");
		this.instrument.play();
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	private String song;

	private Instrument instrument;

}
