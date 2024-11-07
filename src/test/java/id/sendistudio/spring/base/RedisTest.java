package id.sendistudio.spring.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;

@SpringBootTest(classes = RedisTest.TestApplication.class)
public class RedisTest {

    // @Autowired
    // private RedisTemplate<String, Object> redisTemplate;

    // @Test
    // public void clearAllCache() {
    // RedisConnection connection =
    // redisTemplate.getConnectionFactory().getConnection();
    // connection.flushAll();
    // }

    @EnableCaching
    @SpringBootApplication
    @EnableConfigurationProperties(DatabaseProperties.class)
    static public class TestApplication {

    }
}
