package codenest.aopts5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements MindReader {

	private Message thoughts;

	@Pointcut("execution(* codenest.aopts5.Thinker.thinkOfSomething(codenest.aopts5.Message)) && args(thoughts)")//声明切点时用and报错,要用&&
	public void thinking(Message thoughts) {
		
	}
	
	@Before("thinking(thoughts)")
	public void interceptThoughts(Message thoughts) {
		System.out.println("Intercepting volunteer's thoughts: "+thoughts.getContent());
		this.thoughts = thoughts;
	}

	public Message getThoughts() {
		return this.thoughts;
	}

}
