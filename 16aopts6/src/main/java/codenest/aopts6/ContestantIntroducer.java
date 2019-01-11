package codenest.aopts6;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
public class ContestantIntroducer {
	@DeclareParents(value = "codenest.aopts6.Performer+", defaultImpl = Terpsichorean.class)
	public static Dancer dancer;
}
