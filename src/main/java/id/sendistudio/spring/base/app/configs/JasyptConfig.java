package id.sendistudio.spring.base.app.configs;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import id.sendistudio.spring.base.app.configs.properties.DatabaseProperties;

@Configuration
public class JasyptConfig {

    @Bean
    StringEncryptor stringEncryptor(DatabaseProperties databaseProperties) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(databaseProperties.getScreet()); // Kunci dari database.properties
        encryptor.setAlgorithm("PBEWithMD5AndDES"); // Pilih algoritma yang sesuai
        return encryptor;
    }
}