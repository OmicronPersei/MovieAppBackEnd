package springboothackathon.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;
import springboothackathon.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieRepositoryTests {

    private GenreRepository mockedGenreRepository;
    private MovieTableAccess mockedMovieTableAccess;

    private MovieRepository movieRepository;

    @BeforeEach
    public void testInit()
    {
        mockedGenreRepository = mock(GenreRepository.class);
        mockedMovieTableAccess = mock(MovieTableAccess.class);

        movieRepository = new MovieRepositoryImpl(mockedMovieTableAccess, mockedGenreRepository);
    }
    
    @Test
    public void testGetMovies() {
        Predicate<Movie> expectedPredicate = g -> g.getName().equals("blah");

        long genreId = 234324;
        String genreName = "action";
        Genre correspondingGenre = new Genre();
        correspondingGenre.setName(genreName);

        Movie expectedReturnObj = new Movie();
        expectedReturnObj.setGenreId(genreId);
        List<Movie> moviesFromDb = new ArrayList<Movie>();
        moviesFromDb.add(expectedReturnObj);

        List<Movie> listReturnedFromFindAll = mock(List.class);
        when(mockedMovieTableAccess.findAll()).thenReturn(listReturnedFromFindAll);

        Stream<Movie> streamReturnedFromList = mock(Stream.class);
        when(listReturnedFromFindAll.stream()).thenReturn(streamReturnedFromList);

        Stream<Movie> streamReturnedFromFilter = mock(Stream.class);
        when(streamReturnedFromList.filter(expectedPredicate)).thenReturn(streamReturnedFromFilter);

        when(streamReturnedFromFilter.collect(Mockito.any(Collector.class))).thenReturn(moviesFromDb);

        when(mockedGenreRepository.getById(genreId)).thenReturn(correspondingGenre);

        List<Movie> actual = movieRepository.get(expectedPredicate);

        assertEquals(1, actual.size());
        assertEquals(expectedReturnObj, actual.get(0));
        assertEquals(genreName, actual.get(0).getGenreName());
    }
}
