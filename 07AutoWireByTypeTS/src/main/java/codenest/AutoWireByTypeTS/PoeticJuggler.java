package codenest.AutoWireByTypeTS;

public class PoeticJuggler extends Juggler {

	private Poem poem;

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public void perform() {
		super.perform();
		System.out.println("While reciting ... ");
		poem.recite();
	}
}
