package springboothackathon.repositories;

import springboothackathon.models.Genre;
import springboothackathon.models.Movie;

import java.util.List;
import java.util.Optional;
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
            PopulateGenreName(m);
        }

        return resultSetListFromStream;
    }

    private void PopulateGenreName(Movie m)
    {
        Genre g = genreRepository.getById(m.getGenreId());
        m.setGenreName(g.getName());
    }

    @Override
    public Movie getById(Long aLong) {
        Optional<Movie> movieOptional = movieTableAccess.findById(aLong);

        if (movieOptional.isEmpty() == true) {
            return null;
        }

        Movie m = movieOptional.get();

        PopulateGenreName(m);

        return m;
    }

    @Override
    public void add(Movie item) {
        SetGenreIdFromName(item);

        movieTableAccess.save(item);
    }

    @Override
    public void update(Movie item) {
        SetGenreIdFromName(item);

        movieTableAccess.save(item);
    }

    private void SetGenreIdFromName(Movie item)
    {
        String genreName = item.getGenreName();

        Genre correspondingGenre = genreRepository.get(g -> g.getName().equals(genreName)).get(0);

        Long genreId = correspondingGenre.getId();

        item.setGenreId(genreId);
    }

    @Override
    public void delete(Movie item) {
        movieTableAccess.delete(item);
    }
}
