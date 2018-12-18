package com.sky.movies.parentalcontrol;

import com.sky.movies.metadata.MovieService;
import com.sky.movies.metadata.exceptions.TechnicalFailureException;
import com.sky.movies.metadata.exceptions.TitleNotFoundException;
import com.sky.movies.parentalcontrol.exceptions.ParentalControlServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ParentalControlServiceTest {

    @Mock
    private MovieService movieService;

    private ParentalControlService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new ParentalControlService(movieService);
    }

    @Test
    public void canWatchMovie() throws TechnicalFailureException, TitleNotFoundException, ParentalControlServiceException {
        String movieId = "aquaman";
        when(movieService.getParentalControlLevel(movieId)).thenReturn("18");
        boolean canWatch = service.canWatchMovie(ControlLevel.AGE_18, movieId);
        assertThat(canWatch).isTrue();

    }
}