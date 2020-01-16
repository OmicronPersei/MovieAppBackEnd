package springboothackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboothackathon.models.Genre;


@Repository
public interface GenreTableAccess extends JpaRepository<Genre, Long>
{

}