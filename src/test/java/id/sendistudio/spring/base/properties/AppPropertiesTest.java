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

@ActiveProfiles("local")
@SpringBootTest(classes = AppPropertiesTest.TestApplication.class)
public class AppPropertiesTest {

    @Autowired
    private AppProperties properties;

    @MockitoBean
    private DataSource dataSource;

    @Test
    void testAppProperties() {

        Assertions.assertNotNull(properties);
        // application.properties
        String appName = properties.getName();
        String appVersion = properties.getVersion();
        String contactName = properties.getContact().getName();
        String contactEmail = properties.getContact().getEmail();

        Assertions.assertNotNull(appName);
        Assertions.assertNotNull(appVersion);
        Assertions.assertNotNull(contactName);
        Assertions.assertNotNull(contactEmail);
    }

    @SpringBootApplication()
    @EnableConfigurationProperties({ AppProperties.class })
    public static class TestApplication {

    }
}
