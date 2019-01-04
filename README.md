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
* 使用条件表达式，装配布尔量属性
```xml
<property name="song" value="#{other.song!=null?other.song?'Jungle Bell'}"></property>
```
* 使用正则表达式装配布尔量属性
```xml
<property name="validEmail"
			value="#{other.email matches '^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$'}"></property>
```
3、在SpEL上筛选集合
* 在xml中定义集合时需要引入命名空间util，引入方法如下：<br>
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:util="http://www.springframework.org/schema/util"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd 
	http://www.springframework.org/schema/util 
	http://www.springframework.org/schema/util/spring-util.xsd ">
```
* 定义list对象
```xml
<util:list id="cities">
		<bean class="codenest.SpEL2.City" p:name="shenzhen" p:state="IL" p:population="2853114"/>
		<bean class="codenest.SpEL2.City" p:name="shanghai" p:state="IL" p:population="1234568"/>
		<bean class="codenest.SpEL2.City" p:name="beijing" p:state="IL" p:population="652315656"/>
		<bean class="codenest.SpEL2.City" p:name="guangzhou" p:state="IL" p:population="26461788"/>
</util:list>
```
* 定义map对象
```xml
<util:map id="citymap">
		<entry key="shenzhen">
			<bean class="codenest.SpEL2.City" p:name="shenzhen" p:state="IL" p:population="2853114"/>
		</entry>
</util:map>
```
	
* 引入properties文件,如下，引入了类路径下的settings.properties文件
```xml
<util:properties id="settings" location="classpath:settings.properties">
</util:properties>
```
settings.properties文件的内容类似下面
```xml
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql://192.168.8.32:3306/test
db.username=root
db.passwd=root
```
* 通过[]访问list中的成员
```xml
<property name="city" value="#{cities[0]}">
```
* 通过[]访问map中的成员
```xml
<property name="city" value="#{citymap['shenzhen']}"></property>
```
* 按照集合中对象的字段对集合中的对象进行过滤，得到一个新的集合，如下按照population对集合进行筛选,选中第一个人口数大于1000万的城市，类似的表达式还有.?[]选中所有符合条件的对象，.$[]选出最后一个符合条件的对象
```xml
<property name="city" value="#{cities.^[population gt 10000000]}"></property>
```
* 通过.![]对集合中的每个对象进行处理，并返回新的集合
```xml
<property name="cityNames" value="#{cities.?[population gt 1000000].![name + ','+ state]}"></property>
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 07AutoWireTSByName<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 07AutoWireByTypeTS<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 07AotuWireContructorTS<br>
* 设置按照属性名称自动装配属性<br>
　　设置待装配属性bean的autowire为byName，此时装配该bean的属性时会从spring容器中查找id和该属性名成相同的bean进行装配。如下，hyman对象中有一个叫做poem的属性，此时会使用id为poem的bean进行装配。
```xml
<bean id="poem" class="codenest.AutoWireTS.Sonnet29">
</bean>
<bean id="hyman" class="codenest.AutoWireTS.PoeticJuggler" autowire="byName">
</bean>
```
* 设置按照属性类型自动装配属性<br>
　　设置待装配属性的bean的autowire为byType，此时装配该bean的属性时会从spring容器中查找和该属性类型相同的bean进行装配。如下，hyman对象中有一个叫做poem的属性，它的类型是Sonnet29，此时会使用类型为Sonnet29的bean进行装配，如果找到多个符合条件的类型，则抛出异常。
```xml
<!-- 设置按照类型自动装配 -->
  <bean id="hyman" class="codenest.AutoWireByTypeTS.PoeticJuggler" autowire="byType">
  </bean>
```
　　当有多个bean符合条件时，可以设置bean的优先级，如将其primary属性设置为true表示优先采用该bean进行装配，反之设为false则最后考虑使用其装配<br>
```xml
<!-- 设置primary为true，表示装配时选中该bean的优先级最高 -->
  <bean id="poem" class="codenest.AutoWireByTypeTS.Sonnet29" primary="true">
  </bean>
  <!-- 设置primary为false，表示装配时选中该bean的优先级最低 -->
  <bean id="poem2" class="codenest.AutoWireByTypeTS.Sonnet29" primary="false">
  </bean>
```
　　此外，也可以通过设置bean的autowire-candidate属性为false，使得该bean不参与装配<br>
```xml
<!-- 设置autowire-candidate为false表示装配时该bean被排除 -->
  <bean id="poem3" class="codenest.AutoWireByTypeTS.Sonnet29" autowire-candidate="false">
  </bean>
```
* 设置bean按照构造函数自动装配
　　将bean的autowire为constructor时，bean的<constructor-arg>元素将不再需要，Spring会按照类型或者类型寻找该构造函数的入参，如果发现有多个bean可作为该入参，或者找到的入参符合多个构造函数，都会出现编译错误。
```xml
 <bean id="hyman" class="codenest.AotuWireContructorTS.PoeticJuggler" autowire="constructor">
  </bean>
```
* 设置文件中所有bean的默认自动装配类型
　　配置beans标签的default-autowire属性，可以设置该beans下所有bean按照指定方式进行自动装配
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	default-autowire="constructor">
```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 08AutoWireByComment<br>
一、利用@Autowired注解自动装配bean<br>
使用@Autowired注解后，spring会byType去寻找合适的bean进行装配。
* 命名空间的引入
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context  
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
	<context:annotation-config/>
```
* 装配到setter
```java
/*装配到setter*/
@Autowired
public void setInstrument(Instrument instrument) {
	this.instrument = instrument;
}
```
* 装配的构造函数
```java
/*在构造函数上自动装配*/
@Autowired
public Instrumentalist(Instrument instrument){
	this.instrument = instrument;
}
```
* 装配到属性上
```java
/*装配到setter*/
@Autowired
public void setInstrument(Instrument instrument) {
	this.instrument = instrument;
}
```

二、设置装配bean可选，若找不到合适的bean，设置属性为null<br>
```java
@Autowired(required=false)
private Instrument instrument;
```
required为false表示若找不到bean，属性设置为null；为true表示找不到bean则抛出异常<br>

三、限定选择bean<br>
* 在使用@Autowired时指定选择某一个名称的bean
```java
@Autowired(required=false)
@Qualifier("saxphone")
private Instrument instrument;
```
上述代码，在进行自动装配时选择id为saxphone的bean进行装配，此时xml文件中如果有bean的id为saxphone就会被装配。
```xml
<bean id="saxphone" class="codenest.AutoWireByComment.Saxphone">
</bean>
```

* 指定某一参加自动装配bean的范围<br>
首先，在xml中未需要参与竞争装配的bean定义候选集名称
```xml
<bean id="saxphone" class="codenest.AutoWireByComment.Saxphone">
   <qualifier value="saxphone1"/>
</bean>
<bean id="guitar" class="codenest.AutoWireByComment.Guitar">
   <qualifier value="saxphone1"/>
</bean>
```
或者直接在对应的类上面使用该注解：<br>

```java
@Qualifier("saxphone1")
public class Saxphone implements Instrument {	
	public void play() {
		System.out.println("TOOT");
	}
}

```
然后，在使用@Autowired注解时，使用@Qualifier指定候选集的名称，这样spring就会优先从这些候选集中选择这些bean
```java
@Autowired(required=false)
@Qualifier("saxphone")
private Instrument instrument;
```
* 自定义候选集（Qualifier）
我们自定义一个名叫做StreamedInstrument的候选集注解
```java
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface StreamedInstrument {
}
```
在对应的类中添加该候选集注解<br>
```java
@StreamedInstrument
public class Guitar implements Instrument {
	public void play() {
		System.out.println("DIDI");
	}
}
```

在待装配的bean上，使用@Autowired时添加该注解：
```java
/*在属性上自动装配*/
@Autowired(required=false)
@StreamedInstrument
private Instrument instrument;
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 09InjectTS<br>
* @Inject注解的使用方法和Autowired基本一致，下面主要说明其不一致的使用方法之处：
    * @Inject注解没有required属性，也就是说其所标注的依赖关系必须存在。
    * @Inject指定名称注入的标签为@Named对应@Qualifier
    * 使用@Inject时，可以在构造函数处注入一个Provider，Provider接口可以实现延迟注入以及注入Bean多个实例等许多自定义功能：
```java
@Inject
public PoeticJuggler(Provider<Poem> poemProvider) {
	this.poems = new HashSet<Poem>();
	for(int i=0;i<6;i++) {
		poems.add(poemProvider.get());
	}
}
```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 10ValueTS<br>
* 使用Value注解可以注入基本类型的或者SpEL表达式
```java

@Value("5")
private int max;

@Value("#{instrument.sound}")
private String sound;

```

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 11ScanTS<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 11ScanTS2<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 11CreateBeanByJava<br>
一、 使用注解的方式自动检测Bean<br>
　　为了减少xml的配置量，除了使用xml配置bean之外，我们还可以利用注解@Component自动再对应类上进行注解，spring会自动生成该类的的bean。首先需要在配置文件中配置需要生成bean的基础包base-package,spring会检查base-package下所有的注解了@Component的类：，将其生成bean<br>
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context  
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    <context:annotation-config/>
	<context:component-scan base-package="codenest.CreateBeanByJava">
	</context:component-scan>
</beans>
```
　　使用@Component注解时可以用@Component("guitar")的方式指定bean名称，如果没有指定bean名称默认生成的bean名称为该类类名的小写字母形式。<br>
```java
@Component("tom")
public class Musician implements Singer {

	public void show() {
		System.out.print("Musican show ");
	}

}
```
　　其它使用特殊的注解还包括如下：<br>

| 注解  | 用途 |  
| --------   | -----   | 
| @Component        | 标识该类被构造成bean      |  
| @Controller       | 标识将该类定义为Spring MVC contrroller       |   
| @Respository      | 标识将该类定义为数据仓库      |   
| @Service        | 标识将该类定义为服务      |  

二、使用过滤器自动生成bean
　　上述方法，只有我们具有需要创建bean的class的源码时，在可以在源码上进行@Component注解，而通常情况下当我们拿到一个第三方的类，此时我们无法利用@Component注解进行类的自动生成，但是可以使用包含过滤器标签<context:include-filter/>来自动生成基础包下相关的类或者接口实现，使用排除过滤器<context:include-filter/>来排除基础包下相关的类或者的接口实现：<br>
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context  
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    <context:annotation-config/>
	<context:component-scan base-package="codenest.ScanTS">
		<context:include-filter type="assignable" expression="codenest.ScanTS.Instruclist"/>
		<context:include-filter type="assignable" expression="codenest.ScanTS.Instrument"/>
		<context:include-filter type="assignable" expression="codenest.ScanTS.Singer"/>
	</context:component-scan>
</beans>
```
　　如上面的例子，我们定义了基础包为codenest.ScanTS，并定义了3个包含过滤器，该基础包下所有Instrument和Singer的接口实现以及Instruclist类都将被创建成bean。
　　过滤器标签中的type属性表示的是过滤器的类型，assignable表明过滤器自动创建所有派生于expression指定的类，此外还有多种过滤器类型：<br>
  
| 过滤器类型  | 用途 |  
| --------   | -----   | 
| annotation        | 创建指定注解标注的类的bean，使用expression指定的注解      |  
| assignable      | 创建所有派生于expression指定的类的bean       |   
| aspectj      | 创建expression属性所指定的AspectJ表达式所匹配的类的bean      |   
| custom        | 创建自定义的org.springframework.core.type.TypeFilter实现类的bean，该类由expression属性指定      |  
| regex        | 创建于类名称符合expression指定的正则表达式的类的bean     |  

三、使用Java代码定义Bean<br>
　　为了进一步减少xml的配置bean的繁琐，spring还支持使用java代码代替xml来定义bean，首先还需要一个简单的xml来设置基础包：<br>
  ```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context  
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    <context:annotation-config/>
	<context:component-scan base-package="codenest.CreateBeanByJava">
	</context:component-scan>
</beans>

  ```
　　我们在一个java类上使用@Configuration注解，即可表明使用该类来定义相关bean，相当于之前xml文件的<beans>标签：
```java
@Configuration
public class SpringIdoConfig {
}
```
　　我们以方法的方式在上述类中创建bean，每个方法名就是bean的名称，每个方法上使用@Bean注解，相当于xml文件中的<bean>标签：
```java
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

```
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 12AOPTs<br>
　　AOP（面向切面的编程）的提出是为了解耦通用的服务功能如日志服务与业务功能，面向切面的本质其实就是使用代理封装相关的类对象，利用代理调用对象的方法，可以设置在调用相关方法前后进行相应的操作，甚至为该对象增加功能方法。Spring AOP中主要有以下几个概念：<br>
　　（1）连接点：所有可以调用的目标对象的方法。<br>
　　（2）切点（<aop:pointcut>）:调用目标对象的方法。<br>
 　　(3) 通知：定义在方法调用前、后调用哪个通用服务的方法。<br>
 　　(4) 切面（<aop:aspect>）:所有切点和通知加在一起叫做一个切面。<br>
* 声明切面相关的命名空间：
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
```
* 声明一个切面
```xml
<bean id="audience" class="codenest.AOPTs.Audience">
	</bean>
<aop:config>
		<aop:aspect ref="audience">
			<aop:before pointcut="execution(* codenest.AOPTs.Performer.perform(..))"
				method="takeSeats" />
			<aop:before pointcut="execution(* codenest.AOPTs.Performer.perform(..))"
				method="takeOffCellPhones" />
			<aop:after-returning pointcut="execution(* codenest.AOPTs.Performer.perform(..))"
				method="applaud" />
			<aop:after-throwing pointcut="execution(* codenest.AOPTs.Performer.perform(..))"
				method="demandRefund" />
		</aop:aspect>
</aop:config>
```
　　如上代码，标签aop:aspect声明了一个切面，ref中引用的是AOP中通用服务类的bean，<aop:before>、<aop:after-returning>、<aop:after-throwing>表示定义了三种通知，分别在pointcut中指定的方法调用前、调用后、发生异常时进行调用。

* 单独提取出切入点<br>
　　上面的配置中，为每个通知都定义了一样的切入点，显然存在代码冗余，我们可以将切入点提取出来，再在每个通知上分别引用：
```xml
<aop:config>
		<aop:aspect ref="audience">
			<aop:pointcut expression="execution(* codenest.AOPTs.Performer.perform(..))" id="performance"/>
			<aop:before pointcut-ref="performance"
				method="takeSeats" />
			<aop:before pointcut-ref="performance"
				method="takeOffCellPhones" />
			<aop:after-returning pointcut-ref="performance"
				method="applaud" />
			<aop:after-throwing pointcut-ref="performance"
				method="demandRefund" />
		</aop:aspect>
</aop:config> 
```

* 环绕通知
　　以上我们分别定义了三种通知：<aop:before>、<aop:after-returning>、<aop:after-throwing>，每种通知都有一个单独的服务方法的调用，因为方法不同，这使得三种方法之间共享数据有了问题，只能把需要共享的数据定义成一个服务类的成员，但是这样又会出现并发访问的问题。针对这一情况，提出了环绕通知的概念，目标方法调用前后所有操作都在一个通知方法中实现。首先我们定义该通知方法：
```java
public void watchPerformance(ProceedingJoinPoint joinPoint) {

		try {
			System.out.println("the audience is taking their seats");
			System.out.println("the audience is turning Off their cellphones");
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("CLAP CLAP CLAP CLAP");
			System.out.println("The performence took " + (end - start) + " millionseconds");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("We want our money back");
		}

	}
```
　　我们注意到该方法只有一个类型为ProceedingJoinPoint的参数，该参数包含了要调用的目标方法的信息。joinPoint.proceed()就是再调用目标方法，所以以该句代码划分，上面为调用前相关操作，下面为调用后相关操作。对应的xml的声明方法如下：
```xml
<aop:config>
		<aop:aspect ref="audience">
			<aop:pointcut expression="execution(* codenest.AOPTs.Performer.perform(..))" id="performance"/>
			<aop:around pointcut-ref="performance"
				method="watchPerformance" />
		</aop:aspect>
</aop:config>
```









