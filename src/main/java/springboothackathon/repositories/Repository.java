package springboothackathon.repositories;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T, ID> {
    List<T> get(Predicate<T> p);
    T getById(ID id);
    void add(T item);
    void update(T item);
    void delete(T item);
}