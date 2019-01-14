package codenest.aspectjts;

import org.springframework.stereotype.Component;

@Component("hyman")
public class Musician implements Performer {

	public void perform(){
		System.out.println("Musician is playing ...");
	}

}
