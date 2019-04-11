package springmvcdemo.cache.springcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;


public class EcacheTest {

	@Autowired
	@Qualifier("cacheManager")
	private CacheManager cacheManager;

}
