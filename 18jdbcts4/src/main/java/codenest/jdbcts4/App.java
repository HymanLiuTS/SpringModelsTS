package codenest.jdbcts4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Begin");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("codenest/jdbcts4/spring-ido1.xml");
		SpitterDAO jdbcSpitterDAO = (SpitterDAO) ctx.getBean("jdbcSpitterDAO");
		long starttime = System.currentTimeMillis();

		// 删除全部
		jdbcSpitterDAO.deleteAll();
		// 单个插入
		Spitter spitter = new Spitter();
		spitter.setName("hyman");
		spitter.setEmail("879651072@qq.com");
		jdbcSpitterDAO.insert(spitter);
		//查询单列的值
		int id=jdbcSpitterDAO.findIdByName("hyman");

		// 批量插入
		List<Spitter> spitters = new ArrayList<Spitter>();
		for (int i = 0; i < 100; i++) {
			spitter = new Spitter();
			spitter.setName("hyman" + i);
			spitter.setEmail("879651072@qq.com");
			spitters.add(spitter);
		}
		jdbcSpitterDAO.batchInsert(spitters);
		System.out.println("batchInsert spend time: " + (System.currentTimeMillis() - starttime));
		// 单个查询
		spitter = jdbcSpitterDAO.getSpitterByID(id);
		System.out.println(spitter.toString());
		//批量查询
		spitters=jdbcSpitterDAO.getAllSpitters();
		spitters.forEach((x)->System.out.println(x.toString()));
	}
}
