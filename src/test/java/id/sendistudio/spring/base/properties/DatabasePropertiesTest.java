package id.sendistudio.spring.base.properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import id.sendistudio.spring.base.app.configs.properties.AppProperties;
import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;
import id.sendistudio.spring.base.app.configs.properties.ServerProperties;

@ActiveProfiles("local")
@SpringBootTest(classes = DatabasePropertiesTest.TestApplication.class)
public class DatabasePropertiesTest {

    @Autowired
    private DatabaseProperties database;

    @MockitoBean
    private DataSource dataSource;

    @Test
    void testDatabase() {
        String screet = database.getScreet();
        DatabaseProperties.Local local = database.getLocal();
        DatabaseProperties.Dev dev = database.getDev();
        DatabaseProperties.Prod prod = database.getProd();

        Assertions.assertNotNull(screet);
        Assertions.assertNotNull(local);
        Assertions.assertNotNull(dev);
        Assertions.assertNotNull(prod);
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ AppProperties.class, DatabaseProperties.class, ServerProperties.class })
    public static class TestApplication {

    }
}
