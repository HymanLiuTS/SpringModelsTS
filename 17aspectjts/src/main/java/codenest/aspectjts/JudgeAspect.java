package codenest.aspectjts;

public aspect JudgeAspect {
	public JudgeAspect() {
	}

	pointcut perfermance():execution(* perform(..));

    after() returning():perfermance(){
		System.out.print(this.criticismEngine.getCriticism());
	}
	
	private CriticismEngine criticismEngine;
	public void setCriticismEngine(CriticismEngine criticismEngine) {
		this.criticismEngine=criticismEngine;
	}
}
