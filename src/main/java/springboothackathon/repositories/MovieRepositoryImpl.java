package springboothackathon.repositories;

import springboothackathon.models.Genre;
import springboothackathon.models.Movie;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieTableAccess movieTableAccess;
    private GenreRepository genreRepository;

    public MovieRepositoryImpl(MovieTableAccess movieTableAccess, GenreRepository genreRepository) {
        this.movieTableAccess = movieTableAccess;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Movie> get(Predicate<Movie> p) {
        List<Movie> fromFindAll = movieTableAccess.findAll();
        Stream<Movie> streamFromFindAll = fromFindAll.stream();
        Stream<Movie> streamFromStream = streamFromFindAll.filter(p);
        List<Movie> resultSetListFromStream = streamFromStream.collect(Collectors.toList());

        for (Movie m : resultSetListFromStream)
        {
            Genre g = genreRepository.getById(m.getGenreId());
            m.setGenreName(g.getName());
        }

        return resultSetListFromStream;
    }

    @Override
    public Movie getById(Long aLong) {
        return null;
    }

    @Override
    public void add(Movie item) {

    }

    @Override
    public void update(Movie item) {

    }

    @Override
    public void delete(Movie item) {

    }
}
