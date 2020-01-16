package springboothackathon.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GenreTableAccessIntegrationTests {

    @Autowired
    private GenreTableAccess genreTableAccess;

    @Test
    public void testGetGenres() {
        List<Genre> allGenres = genreTableAccess.findAll();

        assertTrue(allGenres.stream().anyMatch(g -> g.getName().equals("action")));
        assertTrue(allGenres.stream().anyMatch(g -> g.getName().equals("drama")));

    }
}