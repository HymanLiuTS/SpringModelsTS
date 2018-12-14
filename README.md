# Spring相关使用模型<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01BeanFromConfigFile<br>
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 01BeanWithBeanFromConfigFile<br>
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
