package springboothackathon.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GenreRepositoryIntegrationTests {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void myMethod() {
        List<Genre> allGenres = genreRepository.findAll();

        assertTrue(allGenres.stream().anyMatch(g -> g.getName() == "action"));
        assertTrue(allGenres.stream().anyMatch(g -> g.getName() == "drama"));

    }
}
