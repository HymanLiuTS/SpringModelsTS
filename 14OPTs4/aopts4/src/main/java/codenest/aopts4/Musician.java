package codenest.aopts4;

import org.springframework.stereotype.Component;

@Component("hyman")
public class Musician implements Performer {

	public void perform(){
		System.out.println("Musician is playing ...");
//		int i=2/0;
	}

}
