package codenest.InitAndDestoryBeanTS;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Auditorium implements InitializingBean ,DisposableBean{
	
	public void turnOnLights() {
		System.out.println("turnOnLights:the lights has been turned on");
	}
	
	public void turnOffLights() {
		System.out.println("turnOffLights:the lights has been turned off");
	}
	
	public void defaultTurnOnLights() {
		System.out.println("defaultTurnOnLights:the lights has been turned on");
	}
	public void defaultTurnOffLights() {
		System.out.println("defaultTurnOffLights:turnOffLights:the lights has been turned off");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet:the lights has been turned on");
	}

	public void destroy() throws Exception {
		System.out.println("destroy:the lights has been turned off");
	}

}
