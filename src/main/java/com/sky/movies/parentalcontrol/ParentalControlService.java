package com.sky.movies.parentalcontrol;

import com.sky.movies.metadata.MovieService;

public class ParentalControlService {

    private MovieService movieService;

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean canWatchMovie(ControlLevel controlLevel, String movieId) {
        return false;
    }
}
