package springboothackathon.controllers;

import org.springframework.web.bind.annotation.*;
import springboothackathon.models.Movie;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    public Movie[] getMockData(){
        Movie[] data = new Movie[4];
        data[0] = new Movie(1, "Avenger's Endgame", 8.5f, "", "Action");
        data[1] = new Movie( 2, "Frozen 2", 9, "", "Adventure");
        data[2] = new Movie( 3, "Gemini Man", 5.7f, "", "Thriller");
        data[3] = new Movie( 4, "Joker", 8.6f, "", "Thriller");
        return data;
    }

    @GetMapping()
    public Movie[] getMovies() {
        return getMockData();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") int id) {
       return new Movie( 4, "Joker", 8.6f, "", "Thriller");
    }

    @PostMapping()
    public String add(@PathVariable("id") int id){
        return "";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id){
        return "";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        return "";
    }
}