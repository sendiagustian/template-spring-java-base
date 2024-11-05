package id.sendistudio.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import id.sendistudio.spring.base.app.configs.properties.AppProperties;
import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;
import id.sendistudio.spring.base.app.configs.properties.ServerProperties;

@SpringBootApplication
@EnableConfigurationProperties({ AppProperties.class, DatabaseProperties.class, ServerProperties.class })
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
