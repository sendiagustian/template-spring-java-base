package id.sendistudio.spring.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;

@SpringBootTest(classes = RedisTest.TestApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testConnection() {
        RedisConnection connection = redisTemplate.getRequiredConnectionFactory().getConnection();
        String ping = connection.ping();

        Assertions.assertEquals("PONG", ping);
    }

    @EnableCaching
    @EnableConfigurationProperties(DatabaseProperties.class)
    @SpringBootApplication(scanBasePackages = "id.sendistudio.spring.base")
    static public class TestApplication {

    }
}
