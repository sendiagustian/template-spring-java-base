package id.sendistudio.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import id.sendistudio.spring.base.app.configs.properties.AppProperties;
import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;
import id.sendistudio.spring.base.app.configs.properties.ServerProperties;

@EnableAsync
@EnableCaching
@EnableRedisRepositories
@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
@EnableConfigurationProperties({ AppProperties.class, DatabaseProperties.class, ServerProperties.class })
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
