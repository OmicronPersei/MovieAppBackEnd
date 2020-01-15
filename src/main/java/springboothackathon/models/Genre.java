package springboothackathon.models;

import javax.persistence.*;

@Entity
@Table(name="Genres")
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId()
    {
        return id;
    }

    public void setId(Long value)
    {
        id = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String value)
    {
        name = value;
    }
}
