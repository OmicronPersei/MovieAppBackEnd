package springboothackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboothackathon.models.Movie;

@Repository
public interface MovieTableAccess extends JpaRepository<Movie, Long>
{

}