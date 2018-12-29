package codenest.AutoWireByComment;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("saxphone1")
public class Saxphone implements Instrument {

	
	public void play() {
		System.out.println("TOOT");
	}

}
