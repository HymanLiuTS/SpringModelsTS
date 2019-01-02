package codenest.ScanTS;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

	public void play() {
		System.out.println("guitar DIDI");
	}

}
