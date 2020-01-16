package springboothackathon.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import springboothackathon.models.Genre;
import springboothackathon.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

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

    @Test
    public void testGetMovieById()
    {
        Long id = 123421L;
        Long genreId = 1398438L;
        String genreName = "action";
        Genre correspondingGenre = new Genre();
        correspondingGenre.setName(genreName);
        Movie movie = new Movie();
        movie.setGenreId(genreId);
        Optional<Movie> movieOptional = Optional.of(movie);

        when(mockedMovieTableAccess.findById(id)).thenReturn(movieOptional);
        when(mockedGenreRepository.getById(genreId)).thenReturn(correspondingGenre);

        Movie actual = movieRepository.getById(id);

        assertSame(movie, actual);
        assertEquals(genreName, actual.getGenreName());
    }

    @Test
    public void testUpdateMovie()
    {
        String genreName = "action";
        Movie m = new Movie();
        m.setGenreName(genreName);

//        Predicate<Genre> expectedPredicate = g -> g.getName().equals(genreName);

        List<Genre> matchingGenres = new ArrayList<Genre>();
        Genre matchingGenre = new Genre();
        Long genreId = 9832L;
        matchingGenre.setId(genreId);
        matchingGenres.add(matchingGenre);
        when(mockedGenreRepository.get(Mockito.any(Predicate.class))).thenReturn(matchingGenres);

        movieRepository.update(m);

        assertEquals(genreId, m.getGenreId());
        verify(mockedMovieTableAccess).save(m);
    }

    @Test
    public void testAddMovie()
    {
        Movie m = new Movie();
        String genreName = "action";
        Long genreId = 9332L;
        m.setGenreName(genreName);

        Genre correspondingGenre = new Genre();
        correspondingGenre.setId(genreId);
        List<Genre> foundGenres = new ArrayList<Genre>();
        foundGenres.add(correspondingGenre);
        when(mockedGenreRepository.get(Mockito.any(Predicate.class))).thenReturn(foundGenres);

        movieRepository.add(m);

        verify(mockedMovieTableAccess).save(m);

        assertEquals(genreId, m.getGenreId());
    }

    @Test
    public void testDeleteMovie()
    {
        Movie m = new Movie();

        movieRepository.delete(m);

        verify(mockedMovieTableAccess).delete(m);
    }
}
