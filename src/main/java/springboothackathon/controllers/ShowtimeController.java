package springboothackathon.controllers;

import org.springframework.web.bind.annotation.*;
import springboothackathon.models.Showtime;

@RestController
@RequestMapping(value = "/showtimes")
public class ShowtimeController {
    @GetMapping()
    public Showtime[] getTheaters() {
        return null;
    }

    @GetMapping("/{id}")
    public Showtime findById(@PathVariable("id") int id) {
        return null;
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
