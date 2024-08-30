package com.example.movie.repository;

import java.util.ArrayList;
import com.example.movie.model.Movie;

public interface MovieRepository {
    ArrayList<Movie> getAllMovies();

    Movie getMovieById(Integer movieId);

    Movie addMovie(Movie movie);

    Movie updateMovie(Integer movieId, Movie movie);

    void deleteMovie(Integer movieId);
}