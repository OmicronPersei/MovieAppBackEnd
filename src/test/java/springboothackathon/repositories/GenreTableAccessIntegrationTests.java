package springboothackathon.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreTableAccessIntegrationTests {

    @Autowired
    private GenreTableAccess genreTableAccess;

    @Test
    public void testGetGenres() {
        Genre newGenre = new Genre();
        newGenre.setName("myNewGenre");

        genreTableAccess.save(newGenre);
        genreTableAccess.flush();

        Genre savedGenre = genreTableAccess
                .findAll()
                .stream().filter(g -> g.getName().equals("myNewGenre"))
                .findFirst()
                .get();

        assertNotNull(savedGenre);
        assertEquals("myNewGenre", savedGenre.getName());
        assertNotEquals(0, savedGenre.getId());
    }
}
