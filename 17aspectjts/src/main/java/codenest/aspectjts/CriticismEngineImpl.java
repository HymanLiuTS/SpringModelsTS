package codenest.aspectjts;

public class CriticismEngineImpl implements CriticismEngine {

	public String getCriticism() {
		int i = (int) (Math.random() * this.criticismPool.length);
		return this.criticismPool[i];
	}

	private String[] criticismPool;

	public void setCriticismPool(String[] criticsmPool) {
		this.criticismPool = criticsmPool;
	}
}
