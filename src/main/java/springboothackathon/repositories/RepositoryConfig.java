package springboothackathon.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Autowired
    private GenreTableAccess genreTableAccess;

    @Autowired
    private MovieTableAccess movieTableAccess;

    @Bean
    public GenreRepository getGenreRepository() {
        return new GenreRepositoryImpl(genreTableAccess);
    }

    @Bean
    public MovieRepository getMovieRepository() { return new MovieRepositoryImpl(movieTableAccess); }
}
