package id.sendistudio.spring.base.app.configs.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@ComponentScan
@PropertySource("classpath:database.properties")
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    @NotNull
    @Value("${jasypt.encryptor.screet}")
    private String screet;

    @NotNull
    private Local local;

    @NotNull
    private Dev dev;

    @NotNull
    private Prod prod;

    @Getter
    @Setter
    public static class Local {
        @NotBlank
        private String redisHost;

        @NotBlank
        private String redisPort;

        @NotBlank
        private String host;

        @NotBlank
        private String port;

        @NotBlank
        private String user;

        @NotBlank
        private String pass;

        @NotBlank
        private String name;
    }

    @Getter
    @Setter
    public static class Dev {
        @NotBlank
        private String redisHost;

        @NotBlank
        private String redisPort;

        @NotBlank
        private String host;

        @NotBlank
        private String port;

        @NotBlank
        private String user;

        @NotBlank
        private String pass;

        @NotBlank
        private String name;
    }

    @Getter
    @Setter
    public static class Prod {
        @NotBlank
        private String redisHost;

        @NotBlank
        private String redisPort;

        @NotBlank
        private String host;

        @NotBlank
        private String port;

        @NotBlank
        private String user;

        @NotBlank
        private String pass;

        @NotBlank
        private String name;
    }
}
