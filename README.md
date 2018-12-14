# Spring相关使用模型<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01BeanFromConfigFile<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01BeanWithBeanFromConfigFile<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01BeanByFactoryFromConfigFile<br>
* 通过配置文件创建SpringBean对象时：<br>

　　1、调用无参构造函数创建：
```xml
<bean id="hyman" class="cn.codenest.springmodelsts.BeadFromConfigFile.Juggler">
  </bean>
```

　　2、调用有参构造函数创建：<br>
```xml
<bean id="hyman" class="cn.codenest.springmodelsts.BeadFromConfigFile.Juggler">
  	<constructor-arg value="15"></constructor-arg>
  </bean>
```
　　3、调用有参构造函数创建，传入SpringBean作为参数：<br>
```xml
<bean id="sonnet29" class="codenest.BeanWithBeanFromConfigFile.Sonnet29">
  </bean>
  
  <bean id="hyman" class="codenest.BeanWithBeanFromConfigFile.PoeticJuggler">
  	<constructor-arg value="15"></constructor-arg>
  	<constructor-arg ref="sonnet29"></constructor-arg>
  </bean>
```
　　4、调用单例模式中类的静态工厂方法创建：<br>
工厂方法：<br>
```java
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
```
配置文件：<br>
```xml
<bean id="hyman" class="codenest.BeanByFactoryFromConfigFile.Stage" factory-method="getInstance">
  	
  </bean>
```
* 加载配置文件的三种程序上下文：<br>

　　1、加载文件系统路径上的配置文件：
```java
    ApplicationContext ctx = new FileSystemXmlApplicationContext("c:/spring-ido1.xml");
		Performer juggler = (Performer) ctx.getBean("hyman");
		juggler.perform();
```
　　2、从项目的ClassPath中加载文件（ClassPath在项目属性中可设置）
```java
    ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/codenest/springmodelsts/BeadFromConfigFile/spring-ido1.xml");
		Performer juggler = (Performer) ctx.getBean("hyman");
		juggler.perform();
```
　　3、XmlWebApplicationContext ———— 从Web应用下的xml文件中装载上下文。

* Bean的创建模式：<br> 
　　利用配置文件创建的Bean在默认情况下是单例的，也就是说上下文getBean()得到的是同一个Bean对象，但是我们有时需要每次getBean时就得到一个新的对象，此时需要在<Bean>中设置其scope=“prototype”。
```xml
<bean id="hyman" class="cn.codenest.springmodelsts.BeadFromConfigFile.Juggler" scope="prototype">
  	<constructor-arg value="15"></constructor-arg>
  </bean>
```
scope可选值：<br>
	
| scope  | 定义 |  
| --------   | -----   | 
| singleton        | 在每一个Spring容器中，一个Bean定义一个对象实例（默认）      |  
| prototype        | 允许Bean的定义可以被实例化任意次      |   
| request        | 在一次Http请求中，每个Bean定义对应一个实例，该作用域仅在Spring MVC中才有效      |   
| session        | 在一个Http Session请求中，每个Bean定义对应一个实例，该作用域仅在Spring MVC中才有效      |   

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 02InitAndDestoryBeanTS<br>
* 定义创建和销毁单个Bean时调用的方法：<br>
```xml
 <bean id="hyman" class="codenest.InitAndDestoryBeanTS.Auditorium" init-method="turnOnLights" destroy-method="turnOffLights">
  </bean>
```
* 定义默认的创建和销毁Bean调用的方法，在创建和销毁每个Bean时都会调用改方法：<br>
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	default-init-method="defaultTurnOnLights" default-destroy-method="defaultTurnOffLights">
```
* 实现InitializingBean和DisposableBean接口来定义创建和销毁Bean时调用的方法：
```java
public class Auditorium implements InitializingBean ,DisposableBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet:the lights has been turned on");
	}

	public void destroy() throws Exception {
		System.out.println("destroy:the lights has been turned off");
	}
}
```
