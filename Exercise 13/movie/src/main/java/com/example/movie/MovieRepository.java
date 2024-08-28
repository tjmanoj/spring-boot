package com.example.movie;

import java.util.ArrayList;

public interface MovieRepository {
    ArrayList<Movie> getAllMovies();
    Movie getMovieById(int movieId);
    Movie addMovie(Movie movie);
    Movie updateMovie(int movieId,Movie movie);
    void deleteMovie(int movieId);
}
