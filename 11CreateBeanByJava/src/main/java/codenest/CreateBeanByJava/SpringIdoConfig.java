package codenest.CreateBeanByJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdoConfig {

	@Bean
	public  Sonnet29 snet() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler hyman() {
		return new PoeticJuggler(15,snet());
	}
}
