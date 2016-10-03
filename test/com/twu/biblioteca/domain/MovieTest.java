package com.twu.biblioteca.domain;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class MovieTest {
    private Movie first;
    private Movie second;

    @Before
    public void setUp() throws Exception {
        first = new Movie("M1", "saw1", "director", "2016", 9);
        second = new Movie("M2", "swa2", "director1", "2016", 9.2);
    }

    @Test
    public void testMovieNotNull() throws Exception {
        assertNotNull(first);
        assertNotNull(second);
    }

    @Test
    public void testMoviesWithSameHashCodeAreEqual() throws Exception {
        second = first;
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testMoviesWithDifferentHashCodeNotEqual() throws Exception {
        assertNotEquals(first.hashCode(), second.hashCode());
    }
}
