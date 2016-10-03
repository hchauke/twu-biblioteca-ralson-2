package com.twu.biblioteca.domain;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {

    private Book first;
    private Book second;

    @Before
    public void setUp() {
        first = new Book("B1", "title", "author", "2005");
        second = new Book("B2", "title1", "author1", "2006");
    }

    @Test
    public void testBookNotNull() throws Exception {
        assertNotNull(first);
        assertNotNull(second);
    }

    @Test
    public void testBooksWithSameHashCodeAreEqual() throws Exception {
        second = first;
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testBooksWithDifferentHashCodeAreNotEqual() throws Exception {
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void should_be_able_to_get_book_column_info() {
        String columnHeader = Book.getColumnHeader();

        assertEquals(columnHeader, "\n" +
                "+-------+----------------------+---------------------+------------------+" + "\n"
                + "|Book id|Book Name             |Director             | Year Published   |" + "\n"
                + "+-------+----------------------+---------------------+------------------+");
    }

}