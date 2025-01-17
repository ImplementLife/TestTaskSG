package sg.il.res.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CommonBeanConfig {
    @Value("${sg.il.res.rest.timeout.connection}")
    private int connectionTimeout;

    @Value("${sg.il.res.rest.timeout.read}")
    private int readTimeout;

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(connectionTimeout))
            .setReadTimeout(Duration.ofMillis(readTimeout))
            .build();

        return template;
    }
}
