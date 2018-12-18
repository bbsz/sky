package com.sky.movies.metadata;

import com.sky.movies.metadata.domain.Movie;
import com.sky.movies.metadata.exceptions.TechnicalFailureException;
import com.sky.movies.metadata.exceptions.TitleNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    static final String PARENTAL_CONTROL_LEVEL_PG = "PG";
    static final String PARENTAL_CONTROL_LEVEL_U  = "U";
    static final String PARENTAL_CONTROL_LEVEL_13 = "13";
    static final String PARENTAL_CONTROL_LEVEL_15 = "15";
    static final String PARENTAL_CONTROL_LEVEL_18 = "18";

    private Map<String, Movie> movies = new HashMap<>();

    public MovieServiceImpl() {
        initMovieDatabase();
    }

    @Override
    public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
        if (movies == null) {
            throw new TechnicalFailureException("Movie database is not accessible!");
        }

        Movie movie = movies.get(movieId);
        if (movie != null) {
            return movie.getParentalControlLevel();
        }
        throw new TitleNotFoundException("Movie cannot be found!");
    }

    private void initMovieDatabase() {
        addMovie("Aquaman", PARENTAL_CONTROL_LEVEL_PG);
        addMovie("Creed II", PARENTAL_CONTROL_LEVEL_PG);
        addMovie("Smallfoot", PARENTAL_CONTROL_LEVEL_U);
        addMovie("Robin Hood", PARENTAL_CONTROL_LEVEL_13);
        addMovie("Free Solo", PARENTAL_CONTROL_LEVEL_13);
        addMovie("A Star Is Born", PARENTAL_CONTROL_LEVEL_15);
        addMovie("Home Alone", PARENTAL_CONTROL_LEVEL_18);
        addMovie("Shoplifters", PARENTAL_CONTROL_LEVEL_18);
        addMovie("The Possession of Hannah Grace", PARENTAL_CONTROL_LEVEL_18);
    }

    private void addMovie(String name, String parentalControlLevel) {
        String movieId = name.replaceAll("\\s+", "_").toLowerCase();
        Movie movie = new Movie(movieId, name, parentalControlLevel);
        movies.put(movieId, movie);
    }
}
