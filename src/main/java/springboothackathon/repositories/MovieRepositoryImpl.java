package springboothackathon.repositories;

import springboothackathon.models.Movie;

import java.util.List;
import java.util.function.Predicate;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieTableAccess movieTableAccess;

    public MovieRepositoryImpl(MovieTableAccess movieTableAccess) {
        this.movieTableAccess = movieTableAccess;
    }

    @Override
    public List<Movie> get(Predicate<Movie> p) {
        return null;
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
