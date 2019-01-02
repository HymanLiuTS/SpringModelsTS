package codenest.ScanTS;

import org.springframework.stereotype.Component;

@Component("tom")
public class Musician implements Singer {

	public void show() {
		System.out.print("Musican show ");
	}

}
