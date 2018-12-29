package codenest.AutoWireByComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instrumentalist implements Performer {

	/*在构造函数上自动装配*/
	//@Autowired
	/*public Instrumentalist(Instrument instrument){
		this.instrument = instrument;
	}*/
	
	/*public Instrumentalist(){
		this.instrument = instrument;
	}*/
	
	public void perform() {
		//System.out.print("Playiing " + this.song + " :");
		this.instrument.play();
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	/*装配到setter*/
	//@Autowired
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	private String song;

	/*在属性上自动装配*/
	@Autowired(required=false)
	//@Qualifier("saxphone1")
	@StreamedInstrument
	private Instrument instrument;

}
