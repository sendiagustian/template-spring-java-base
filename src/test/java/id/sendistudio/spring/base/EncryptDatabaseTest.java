package id.sendistudio.spring.base;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;
import id.sendistudio.spring.base.app.utils.EncryptUtil;

@SpringBootTest
// @ActiveProfiles("local")
// @ActiveProfiles("dev")
@ActiveProfiles("prod")
public class EncryptDatabaseTest {

    @MockBean
    private DataSource dataSource;

    @Autowired
    DatabaseProperties database;

    @Autowired
    private EncryptUtil encryptUtil;

    @Test
    void testEncrypt() {
        encryptUtil.encryptDatabaseCredential();
    }

    @SpringBootApplication
    @EnableConfigurationProperties(DatabaseProperties.class)
    public static class TestApplication {

    }
}
