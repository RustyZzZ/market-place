package diachuk.project.marketplace.configuration;

import java.util.HashMap;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

	@Bean
	public RedissonClient redisson(){
		var config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		return Redisson.create(config);
	}


	@Bean("redisCacheManager")
	public CacheManager cacheManager(RedissonClient redisson){
		var config = new HashMap<String, CacheConfig>();
		config.put("currencies", new CacheConfig(2*60*1000, 30*1000));
		return new RedissonSpringCacheManager(redisson, config);
	}
}
