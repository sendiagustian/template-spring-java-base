package id.sendistudio.spring.base.app.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import id.sendistudio.spring.base.constants.ExcludeEndpoint;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    ExcludeEndpoint excludeEndpoint;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(auth -> {
            List<String> tokenExcludes = excludeEndpoint.getTokenExcludes();
            List<String> logExcludes = excludeEndpoint.getLogExcludes();

            List<String> allExcludes = new ArrayList<>();
            allExcludes.addAll(tokenExcludes);
            allExcludes.addAll(logExcludes);

            String[] excludesData = allExcludes.toArray(new String[0]);

            auth.requestMatchers(HttpMethod.GET, excludesData).permitAll();
            auth.requestMatchers(HttpMethod.POST, excludesData).permitAll();
            auth.requestMatchers(HttpMethod.PUT, excludesData).permitAll();
            auth.requestMatchers(HttpMethod.DELETE, excludesData).permitAll();

            auth.anyRequest().permitAll();
        });

        http.csrf(csrf -> csrf.disable());

        http.cors(cors -> {
            cors.configurationSource(request -> {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("*"));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                configuration.setAllowedHeaders(List.of("*"));
                return configuration;
            });
        });

        return http.build();
    }

    @Bean
    CorsConfigurationSource configurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest arg0) {
                CorsConfiguration configuration = new CorsConfiguration();

                configuration.setAllowedOrigins(Arrays.asList("*"));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                configuration.setAllowedHeaders(List.of("*"));

                return configuration;
            }

        };
    }
}
