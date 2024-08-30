package com.example.movie.model;

public class Movie {
    private Integer movieId;
    private String movieName;
    private String leadActor;

    public Movie(Integer movieId, String movieName, String leadActor) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    // getters
    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    // setters
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

}