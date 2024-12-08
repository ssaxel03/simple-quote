package com.ssaxel03.simplequote.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Envconfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();
    }
}
