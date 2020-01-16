package springboothackathon.controllers;

import org.springframework.web.bind.annotation.*;
import springboothackathon.models.Genre;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    @GetMapping()
    public Genre[] getTheaters() {
        return null;
    }

    @GetMapping("/{id}")
    public Genre findById(@PathVariable("id") int id) {
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
