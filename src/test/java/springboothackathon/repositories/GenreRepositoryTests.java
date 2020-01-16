package springboothackathon.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreRepositoryTests {
    private GenreTableAccess mockedGenreReository;
    private GenreRepository genreRepository;


    @BeforeEach
    public void TestInit()
    {
        mockedGenreReository = mock(GenreTableAccess.class);
        genreRepository = new GenreRepositoryImpl(mockedGenreReository);
    }

    @Test
    public void testGetGenres()
    {
        Predicate<Genre> expectedPredicate = g -> g.getName().equals("blah");

        Genre expectedReturnObj = new Genre();
        List<Genre> genresFromDb = new ArrayList<>();
        genresFromDb.add(expectedReturnObj);

        when(mockedGenreReository.findAll().stream().filter(expectedPredicate)).thenReturn(genresFromDb.stream());

        List<Genre> actual = genreRepository.Get(expectedPredicate);

        assertEquals(1, actual.size());
        assertEquals(expectedReturnObj, actual.get(0));
    }
}
