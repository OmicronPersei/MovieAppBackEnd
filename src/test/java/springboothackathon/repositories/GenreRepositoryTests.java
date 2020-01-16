package springboothackathon.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GenreRepositoryTests {
    private GenreTableAccess mockedGenreTableAccess;
    private GenreRepository genreRepository;


    @BeforeEach
    public void TestInit()
    {
        mockedGenreTableAccess = mock(GenreTableAccess.class);
        genreRepository = new GenreRepositoryImpl(mockedGenreTableAccess);
    }

    @Test
    public void testGetGenres()
    {
        Predicate<Genre> expectedPredicate = g -> g.getName().equals("blah");

        Genre expectedReturnObj = new Genre();
        List<Genre> genresFromDb = new ArrayList<>();
        genresFromDb.add(expectedReturnObj);

        List<Genre> listReturnedFromFindAll = mock(List.class);
        when(mockedGenreTableAccess.findAll()).thenReturn(listReturnedFromFindAll);

        Stream<Genre> streamReturnedFromList = mock(Stream.class);
        when(listReturnedFromFindAll.stream()).thenReturn(streamReturnedFromList);

        Stream<Genre> streamReturnedFromFilter = mock(Stream.class);
        when(streamReturnedFromList.filter(expectedPredicate)).thenReturn(streamReturnedFromFilter);

        when(streamReturnedFromFilter.collect(Mockito.any(Collector.class))).thenReturn(genresFromDb);

        List<Genre> actual = genreRepository.get(expectedPredicate);

        assertEquals(1, actual.size());
        assertEquals(expectedReturnObj, actual.get(0));
    }

    @Test
    public void testAddGenre() {
        Genre genreToAdd = new Genre();

        genreRepository.add(genreToAdd);

        verify(mockedGenreTableAccess).save(genreToAdd);
    }

    @Test
    public void testUpdateGenre() {
        Genre genreToUpdate = new Genre();

        genreRepository.update(genreToUpdate);

        verify(mockedGenreTableAccess).save(genreToUpdate);
    }

    @Test
    public void testDeleteGenre() {
        Genre genreToDelete = new Genre();

        genreRepository.delete(genreToDelete);

        verify(mockedGenreTableAccess).delete(genreToDelete);
    }

    @Test
    public void testGetGenreByIdWhenGenreFound() {
        Long id = 123L;
        Genre expectedGenre = new Genre();
        Optional<Genre> genreOptional = Optional.of(expectedGenre);

        when(mockedGenreTableAccess.findById(id)).thenReturn(genreOptional);

        Genre actual = genreRepository.getById(id);

        assertSame(expectedGenre, actual);
    }

    @Test
    public void testGetGenreByIdWhenGenreNOTFound() {
        Long id = 123L;
        Optional<Genre> genreOptional = Optional.empty();

        when(mockedGenreTableAccess.findById(id)).thenReturn(genreOptional);

        Genre actual = genreRepository.getById(id);

        assertNull(actual);
    }
}
