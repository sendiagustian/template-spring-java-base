package id.sendistudio.spring.base.app.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import id.sendistudio.spring.base.app.configs.properties.AppProperties;
import id.sendistudio.spring.base.app.configs.properties.ServerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

        @Autowired
        Environment env;

        @Autowired
        AppProperties appProperties;

        @Autowired
        ServerProperties serverProperties;

        @Bean
        OpenAPI customOpenAPI() {

                String activeProfile = env.getActiveProfiles().length > 0 ? env.getActiveProfiles()[0] : "local";
                String allowedHost;

                if ("dev".equals(activeProfile)) {
                        // allowedHost = serverProperties.getDev().getHost();
                        allowedHost = serverProperties.getDev().getHost() + ":"
                                        + serverProperties.getDev().getPort();
                } else if ("prod".equals(activeProfile)) {
                        allowedHost = serverProperties.getProd().getHost();
                } else {
                        allowedHost = serverProperties.getLocal().getHost() + ":"
                                        + serverProperties.getLocal().getPort();
                }

                Server server = new Server();
                server.setUrl(allowedHost);

                Contact contact = new Contact();
                contact.setEmail(appProperties.getContact().getEmail());
                contact.setName(appProperties.getContact().getName());

                License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

                Info info = new Info()
                                .title(appProperties.getName())
                                .version(appProperties.getVersion())
                                .contact(contact)
                                .description(appProperties.getDesc())
                                .license(mitLicense);

                return new OpenAPI().info(info).servers(List.of(server));
        }
}
