package springboothackathon.repositories;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> {
    List<T> Get(Predicate<T> p);
    void Add(T item);
    void Update(T item);
    void Delete(Predicate<T> p);
}