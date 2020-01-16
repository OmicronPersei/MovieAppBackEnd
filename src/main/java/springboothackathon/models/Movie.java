package springboothackathon.models;

import javax.persistence.*;

@Entity
@Table(name="Movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Rating")
    private float rating;

    @Column(name="ImageFile")
    private String imageFile;

    @Column(name="GenreId")
    private Long GenreId;

    @Transient
    private String genreName;

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float value) {
        rating = value;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String value) {
        imageFile = value;
    }

    public String getGenreName(){
        return genreName;
    }

    public void setGenreName(String value) {
        genreName = value;
    }
}
