package springboothackathon.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MovieTableAccessIntegrationTests {

    @Autowired
    private MovieTableAccess movieTableAccess;

    @Test
    public void testGetMovies() {
        Movie singularMovie = movieTableAccess.findAll().stream().filter(m -> m.getName().equals("Pulp Fiction")).findFirst().get();

        assertNotNull(singularMovie);

        assertEquals("Pulp Fiction", singularMovie.getName());
//        assertEquals("action", singularMovie.getGenreName());
    }
}
