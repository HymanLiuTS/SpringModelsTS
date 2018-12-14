package codenest.BeanByFactoryFromConfigFile;

public class Stage {
	private Stage() {
	}

	private static class StageSingleonHolder {
		static Stage instance = new Stage();
	}

	public static Stage getInstance() {
		return StageSingleonHolder.instance;
	}

	public void perform() {
		System.out.println("Hello World");
	}
}
