package springboothackathon.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springboothackathon.models.Theater;

import java.util.List;

@Component
public interface TheaterService {
    @Bean
    List<Theater> getAllTheaters();
}
