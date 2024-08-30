package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.model.MovieRowMapper;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

@Service
public class MovieH2Service implements MovieRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Movie> getAllMovies() {
        List<Movie> movies = db.query("select * from MOVIELIST", new MovieRowMapper());
        return new ArrayList<>(movies);
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        try {
            return db.queryForObject("SELECT * FROM MOVIELIST WHERE movieId =?", new MovieRowMapper(), movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        db.update("INSERT INTO MOVIELIST(movieName,leadActor) VALUES(?,?)", movie.getMovieName(), movie.getLeadActor());
        Movie savedMovie = db.queryForObject("select * from MOVIELIST where movieName = ?", new MovieRowMapper(),
                movie.getMovieName());
        return savedMovie;
    }

    @Override
    public Movie updateMovie(Integer movieId, Movie movie) {
        try {
            if (movie.getMovieName() != null) {
                db.update("Update MOVIELIST set movieName = ? where movieId=?", movie.getMovieName(), movieId);
            }
            if (movie.getLeadActor() != null) {
                db.update("Update MOVIELIST set leadActor = ? where movieId=?", movie.getLeadActor(), movieId);
            }

            return getMovieById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(Integer movieId) {
        try {
            db.update("DELETE FROM MOVIELIST WHERE movieId =?", movieId);
            throw new ResponseStatusException(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}
