package com.sky.movies.metadata;

import com.sky.movies.metadata.exceptions.TechnicalFailureException;
import com.sky.movies.metadata.exceptions.TitleNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static com.sky.movies.metadata.MovieServiceImpl.PARENTAL_CONTROL_LEVEL_13;
import static com.sky.movies.metadata.MovieServiceImpl.PARENTAL_CONTROL_LEVEL_15;
import static com.sky.movies.metadata.MovieServiceImpl.PARENTAL_CONTROL_LEVEL_18;
import static com.sky.movies.metadata.MovieServiceImpl.PARENTAL_CONTROL_LEVEL_PG;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceImplTest {

    private MovieServiceImpl movieService;

    @Before
    public void setUp() throws Exception {
        movieService = new MovieServiceImpl();
    }

    @Test
    public void getParentalControlLevel() throws TechnicalFailureException, TitleNotFoundException {
        assertControlLevel("aquaman", PARENTAL_CONTROL_LEVEL_PG);
        assertControlLevel("robin_hood", PARENTAL_CONTROL_LEVEL_13);
        assertControlLevel("a_star_is_born", PARENTAL_CONTROL_LEVEL_15);
        assertControlLevel("shoplifters", PARENTAL_CONTROL_LEVEL_18);
    }

    @Test(expected = TitleNotFoundException.class)
    public void getParentalControlLevelTitleNotFound() throws TechnicalFailureException, TitleNotFoundException {
        assertControlLevel("batman", PARENTAL_CONTROL_LEVEL_PG);
    }

    private void assertControlLevel(String movieId, String expectedControlLevel) throws TechnicalFailureException, TitleNotFoundException {
        String actualControlLevel = movieService.getParentalControlLevel(movieId);
        assertThat(actualControlLevel).isEqualTo(expectedControlLevel);
    }
}