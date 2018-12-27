package codenest.AotuWireContructorTS;

public class PoeticJuggler extends Juggler {

	private int i;
	private Poem poem;

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public PoeticJuggler(int i, Poem poem) {
		this.poem = poem;
		this.i = i;
	}

	public PoeticJuggler(Poem poem) {
		this.poem = poem;
	}

	public void perform() {
		super.perform();
		System.out.println("While reciting ... ");
		poem.recite();
	}
}
