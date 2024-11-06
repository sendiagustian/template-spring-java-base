package id.sendistudio.spring.base.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import id.sendistudio.spring.base.app.middlewares.LogInterceptorMiddleware;
import id.sendistudio.spring.base.app.middlewares.TokenInterceptorMiddleware;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptorMiddleware logInterceptorMiddleware;

    @Autowired
    TokenInterceptorMiddleware tokenInterceptorMiddleware;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    @Async
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        // Daftarkan interceptor ke semua request API
        registry.addInterceptor(logInterceptorMiddleware).addPathPatterns("/api/**");
        registry.addInterceptor(tokenInterceptorMiddleware).addPathPatterns("/api/**");
    }
}