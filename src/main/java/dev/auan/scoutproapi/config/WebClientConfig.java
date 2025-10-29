package dev.auan.scoutproapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final String geminiApiUrl = System.getenv("GEMINI_API_URL");

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(geminiApiUrl).build();
    }

}
