package id.sendistudio.spring.base.properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import id.sendistudio.spring.base.app.configs.properties.AppProperties;
import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;
import id.sendistudio.spring.base.app.configs.properties.ServerProperties;

@ActiveProfiles("local")
@SpringBootTest(classes = ServerPropertiesTest.TestApplication.class)
public class ServerPropertiesTest {

    @Autowired
    private ServerProperties server;

    @MockBean
    private DataSource dataSource;

    @Test
    void testServer() {
        ServerProperties.Local local = server.getLocal();
        ServerProperties.Dev dev = server.getDev();
        ServerProperties.Prod prod = server.getProd();

        Assertions.assertNotNull(local);
        Assertions.assertNotNull(dev);
        Assertions.assertNotNull(prod);
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ AppProperties.class, DatabaseProperties.class, ServerProperties.class })
    public static class TestApplication {

    }
}
