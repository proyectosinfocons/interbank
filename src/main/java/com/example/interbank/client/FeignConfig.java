package com.example.interbank.client;



import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FeignConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }


}
