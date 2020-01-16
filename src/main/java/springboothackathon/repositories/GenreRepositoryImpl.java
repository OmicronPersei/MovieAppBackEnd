package springboothackathon.repositories;

import springboothackathon.models.Genre;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenreRepositoryImpl implements GenreRepository {

    private GenreTableAccess genreTableAccess;

    public GenreRepositoryImpl(GenreTableAccess genreTableAccess) {
        this.genreTableAccess = genreTableAccess;
    }

    @Override
    public List<Genre> Get(Predicate<Genre> p) {
        return genreTableAccess.findAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void Add(Genre item) {

    }

    @Override
    public void Update(Genre item) {

    }

    @Override
    public void Delete(Predicate<Genre> p) {

    }
}
