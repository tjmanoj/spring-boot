package com.example.movie;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(movieId, updatedMovie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
    }
}
