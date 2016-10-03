package com.twu.biblioteca.service;

import com.twu.biblioteca.businessLogic.extend.MovieService;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieService = new MovieService();
    }

    @Test
    public void should_be_able_to_get_movie_list() {
        List<Movie> movies = movieService.listItems();

        assertFalse(movies.isEmpty());
        Movie movie = movies.get(0);
        assertEquals(movie.getId(), "M1");
        assertEquals(movie.getName(), "Rambo 1");
        assertEquals(movie.getYear(), "2015");
        assertEquals(movie.getDirector(), "sylvester stallone");
        assertEquals(movie.getRating(), 8.5, 0.000001);
    }

    @Test
    public void should_be_able_to_checkout_movie() {
        String message = movieService.checkoutItem("M2", "100-0001");
        assertEquals(message, "Thank you! Enjoy the movie!");
    }

    @Test
    public void should_not_checkout_movie_when_movie_not_exists() {
        String message = movieService.checkoutItem("M4", "100-0001");
        assertEquals(message, "That movie is not available.");
    }

    @Test
    public void should_be_able_to_return_movie() {
        movieService.checkoutItem("M1","100-0001");
        String message = movieService.returnCheckedItem("M1", "100-0001");
        assertEquals(message, "Thank you for returning the movie.");
    }

    @Test
    public void should_not_return_movie_when_movie_id_is_incorrect() {
        String message = movieService.returnCheckedItem("MX", "100-0001");
        assertEquals(message, "That is not a valid movie to return.");
    }

    @Test
    public void should_not_return_movie_when_reader_id_is_incorrect() {
        movieService.checkoutItem("M1", "100-0001");
        String message = movieService.returnCheckedItem("M1", "XXX-XXXX");
        assertEquals(message, "That is not a valid movie to return.");
    }

    @Test
    public void should_be_able_to_generate_movie_column_header() {
        assertEquals(movieService.generateItemColumnHeader(), Movie.getColumnHeader());
    }

    @Test
    public void should_be_able_to_generate_movie_column_content() {
        Movie movie = new Movie("id", "name", "2015", "director", 8);
        assertEquals(movieService.generateItemColumnContent(movie), movie.getColumnContent());
    }
}
