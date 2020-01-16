package springboothackathon.repositories;

import springboothackathon.models.Genre;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenreRepositoryImpl implements GenreRepository {

    private GenreTableAccess genreTableAccess;

    public GenreRepositoryImpl(GenreTableAccess genreTableAccess) {
        this.genreTableAccess = genreTableAccess;
    }

    @Override
    public List<Genre> get(Predicate<Genre> p) {
        List<Genre> fromFindAll = genreTableAccess.findAll();
        Stream<Genre> streamFromFindAll = fromFindAll.stream();
        Stream<Genre> streamFromStream = streamFromFindAll.filter(p);
        List<Genre> resultSetListFromStream = streamFromStream.collect(Collectors.toList());


        return resultSetListFromStream;
    }

    @Override
    public void add(Genre item) {
        genreTableAccess.save(item);
    }

    @Override
    public void update(Genre item) {
        genreTableAccess.save(item);
    }

    @Override
    public void delete(Genre item) {
        genreTableAccess.delete(item);
    }
}
