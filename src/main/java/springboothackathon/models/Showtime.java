package springboothackathon.models;

public class Showtime {
    private int id;
    private String movieName;
    private String theaterName;
    private String time;

    public Showtime(int _id, String _movieName, String _theaterName, String _time){
        this.id = _id;
        this.movieName = _movieName;
        this.theaterName = _theaterName;
        this.time = _time;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getTime() {
        return time;
    }
}
