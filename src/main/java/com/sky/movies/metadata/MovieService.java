package com.sky.movies.metadata;

import com.sky.movies.metadata.exceptions.TechnicalFailureException;
import com.sky.movies.metadata.exceptions.TitleNotFoundException;

public interface MovieService {

    public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
