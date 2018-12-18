package com.sky.movies.parentalcontrol;

import com.sky.movies.metadata.MovieService;
import com.sky.movies.metadata.exceptions.TechnicalFailureException;
import com.sky.movies.metadata.exceptions.TitleNotFoundException;
import com.sky.movies.parentalcontrol.exceptions.ParentalControlServiceException;

public class ParentalControlService {

    private MovieService movieService;

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean canWatchMovie(ControlLevel controlLevel, String movieId) throws ParentalControlServiceException {
        ControlLevel movieControlLevel = movieParentalControlLevel(movieId);
        if (movieControlLevel == null) {
            return false;
        }
        return controlLevel.canWatch(movieControlLevel);
    }

    private ControlLevel movieParentalControlLevel(String movieId) throws ParentalControlServiceException {
        try {
            String moviePcl = movieService.getParentalControlLevel(movieId);
            return ControlLevel.resolve(moviePcl);
        } catch (TitleNotFoundException e) {
            throw new ParentalControlServiceException("Parental Control Level cannot be established!");
        } catch (TechnicalFailureException e) {
            return null;
        }
    }
}
