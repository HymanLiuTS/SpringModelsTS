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
　　4、调用有参构造函数创建，使用内部Bean作为构造函数参数：<br>
```xml
 <bean id="hyman" class="codenest.BeanWithInnerBeanFromConfigFile.PoeticJuggler">
  	<constructor-arg value="15"></constructor-arg>
  	<constructor-arg>
  	    <bean id="sonnet29" class="codenest.BeanWithInnerBeanFromConfigFile.Sonnet29"></bean>
  	</constructor-arg>
  </bean>
```
　　
  5、调用单例模式中类的静态工厂方法创建：<br>
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

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 03BeanPropertyOfBaseType<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 04BeanPropertyFromP<br>
* 通过<Property>标签注入Bean的属性
    * 需定义了属性的setter
    * 注入的属性可为基本类型（通过value设置）和Bean（通过ref引用）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="saxphone" class="codenest.BeanPropertyOfBaseType.Saxphone"></bean>
	<bean id="hyman" class="codenest.BeanPropertyOfBaseType.Instrumentalist">
		<property name="song" value="Jingle Bells"></property>
		<property name="instrument" ref="saxphone"></property>
	</bean>

</beans>	
```

* 通过命名空间p注入Bean的属性
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="saxphone" class="codenest.BeanPropertyFromP.Saxphone"></bean>
	<bean id="hyman" class="codenest.BeanPropertyFromP.Instrumentalist"
			p:song="Jungle Bells" 
			p:instrument-ref="saxphone">

	</bean>

</beans>
```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 05BeanPropertyOfCollection<br>
* 装配Bean的Collection成员时，在配置文件中使用<list>或者<set>都可<br>
```xml
<bean id="saxphone" class="codenest.BeanPropertyOfCollection.Saxphone"></bean>
	<bean id="guitar" class="codenest.BeanPropertyOfCollection.Guitar"></bean>
	<bean id="hyman" class="codenest.BeanPropertyOfCollection.Instrumentalist">
		<property name="song" value="Jingle Bells"></property>
		<property name="instruments">
<!-- 		<list>
			<ref bean="saxphone"/>
			<ref bean="guitar"/>
		</list> -->
		<set>
			<ref bean="saxphone"/>
			<ref bean="guitar"/>
		</set>
		</property>
	</bean>	
```
	
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 05BeanPropertyOfMap<br>
* 装配Bean的map成员时，在配置文件中使用<map>
```xml
<bean id="saxphone" class="codenest.BeanPropertyOfMap.Saxphone"></bean>
	<bean id="guitar" class="codenest.BeanPropertyOfMap.Guitar"></bean>
	<bean id="hyman" class="codenest.BeanPropertyOfMap.Instrumentalist">
		<property name="song" value="Jingle Bells"></property>
		<property name="instruments">
			<map>
				<entry key="guitar" value-ref="guitar"></entry>
				<entry key="saxphone" value-ref="saxphone"></entry>
			</map>
		</property>
	</bean>	
```
　　在<map>中<entry>元素由一个键和一个值组成，键和值可以是简单类型，也可以是对其它bean的引用，锁支持的属性如下表：<br>
	
| 属性  | 用途 |  
| --------   | -----   | 
| key        | 指定map中entry的键为String      |  
| key-ref        | 指定map中entry的键为上下文中其它bean的引用       |   
| value        | 指定map中entry的值为String      |   
| value-ref        | 指定map中entry的值为上下文中其它bean的引用      |   

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 05BeanPropertyOfProperties<br>
* Properties和map类型的区别是前者的key和value都是Spring类型。
* <props>元素用来定义一个Properties类型的集合值。
* <prop>元素用来定义<props>集合的一个成员。
* 使用<null/>为一个类属性装配null值。
```xml
<bean id="hyman" class="codenest.BeanPropertyOfProperties.Instrumentalist">
		<!-- 指定属性为null值 -->
		<property name="song"><null/></property>
		<property name="instruments">
			<props>
				<prop key="guitar">DI</prop>
				<prop key="saxphone">HOOP</prop>
			</props>
		</property>
	</bean>
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 06SpELTS<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 06SpELTS1<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 06SpELTS2<br>
　　SpEL是Spring Expresion Language的简称，是在Spring配置xml中可以执行的简单语言，区别于之前静态地从配置文件中加载Bean或者装载Bean属性，SpEL实现了动态地加载Bean或者装载Bean属性。<br><br>
1、利用SpEL装载字面值<br>
* 使用SpEl装载字符串、整形等普通变量
```xml
<property name="message" value="#{'hello'}"></property>
```
* 使用SpEL获取Bean引用的属性,tom为另一个bean
```xml
<property name="song" value="#{tom.song}"></property>
```
* 使用SpEL调用Bean引用的方法，tom为另一个bean
```xml
<property name="song" value="#{tom.getSong()?.toUpperCase()}"></property>
```
* 使用SpEL调用静态函数,使用T()将命名空间和静态函数所属的类括起来。
```xml
<property name="age" value="#{T(java.lang.Math).random()}"></property>
```
2、在SpEL的值上进行操作
* 使用SpEL进行数值运算，other为另外一个bean，其支持的运算操作符包括：+、-、*、/、^
```xml
<property name="fullName" value="#{other.firstName +' ' + other.lastName}"></property>	
```
* 使用SpEL进行关系运算，装配布尔量属性，other为另外一个bean，其支持的逻辑运算符包括eq（==）、lt（<）、le（<=）、gt（>）、ge（>=)。
```xml
<property name="isAdult" value="#{other.age ge 18}"></property>
```
* 使用逻辑表达式，装配布尔量属性，SpEL支持的逻辑表达式包括and、or、not、!
```xml
<property name="isMan" value="#{other.age ge 18 and sex==1}"></property>
```
* 使用条件表达式
```xml
<property name="song" value="#{other.song!=null?other.song?'Jungle Bell'}"></property>
```
	
