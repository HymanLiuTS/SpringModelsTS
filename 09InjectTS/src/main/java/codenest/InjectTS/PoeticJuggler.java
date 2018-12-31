package codenest.InjectTS;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class PoeticJuggler extends Juggler {

	@Inject
	@Named("poem1")
	public PoeticJuggler(Poem poem) {
		this.poem = poem;
	}

	//@Inject
	public PoeticJuggler(Provider<Poem> poemProvider) {
		this.poems = new HashSet<Poem>();
		for(int i=0;i<6;i++) {
			poems.add(poemProvider.get());
		}
	}

	// @Inject
	private Poem poem;

	// @Inject
	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	private Set<Poem> poems;

	public void perform() {
		
			super.perform();
			System.out.println("While reciting ... ");
			poem.recite();
			
	}
}
