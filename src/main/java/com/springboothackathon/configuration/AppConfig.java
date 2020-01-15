package com.springboothackathon.configuration;

import com.springboothackathon.services.TheaterService;
import com.springboothackathon.services.TheaterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TheaterService theaterService() {
        return new TheaterServiceImpl();
    }
}
