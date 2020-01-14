package springboothackathon.repositories;

public class Genre {
    private String name;
    private int id;

    public Genre(String Name) {
        this.name = Name;
    }

    public Genre() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
