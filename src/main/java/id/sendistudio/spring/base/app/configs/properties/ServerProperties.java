package id.sendistudio.spring.base.app.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ComponentScan
@PropertySource("classpath:server.properties")
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private Local local;
    private Dev dev;
    private Prod prod;

    @Getter
    @Setter
    public static class Local {
        private String address;
        private String host;
        private String port;
    }

    @Getter
    @Setter
    public static class Dev {
        private String address;
        private String host;
        private String port;
    }

    @Getter
    @Setter
    public static class Prod {
        private String address;
        private String host;
        private String port;
    }
}
