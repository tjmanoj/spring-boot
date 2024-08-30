package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {
    @Autowired
    private MovieH2Service movieService;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable Integer movieId, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(movieId, updatedMovie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
    }
}