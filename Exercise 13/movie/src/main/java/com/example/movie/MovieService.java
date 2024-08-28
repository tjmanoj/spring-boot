package com.example.movie;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    private int movieUniqueId = 6;
    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    @Override
    public ArrayList<Movie> getAllMovies() {
        Collection<Movie> movies = movieList.values();
        return new ArrayList<>(movies);
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieList.get(movieId);
    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setMovieId(movieUniqueId++);
        movieList.put(movie.getMovieId(), movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        Movie oldMovie = movieList.get(movieId);
        if (oldMovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (movie.getMovieName() != null) {
            oldMovie.setMovieName(movie.getMovieName());
        }

        if (movie.getLeadActor() != null) {
            oldMovie.setLeadActor(movie.getLeadActor());
        }

        return oldMovie;
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        movieList.remove(movieId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
