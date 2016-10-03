package com.twu.biblioteca.service;

import com.twu.biblioteca.businessLogic.ItemService;
import com.twu.biblioteca.businessLogic.extend.BookService;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {

    private ItemService bookService;

    @Before
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void should_be_able_to_checkout_book() {
        String message = bookService.checkoutItem("B3", "100-0001");
        assertEquals(message, "That book is not available.");
    }

    @Test
    public void should_not_checkout_book_when_book_is_already_checked_out() {
        bookService.checkoutItem("B1", "100-00001");
        String message = bookService.checkoutItem("B3", "100-0001");
        assertEquals(message, "That book is not available.");
    }

    @Test
    public void should_not_checkout_book_when_book_not_exists() {
        String message = bookService.checkoutItem("BX", "100-0001");
        assertEquals(message, "That book is not available.");
    }

    @Test
    public void should_be_able_to_return_book() {
        bookService.checkoutItem("B0001", "111-1111");
        String message = bookService.returnCheckedItem("B0001", "111-1111");
        assertEquals(message, "That is not a valid book to return.");
    }

    @Test
    public void should_not_return_book_when_book_id_is_incorrect() {
        String message = bookService.returnCheckedItem("BX", "100-0001");
        assertEquals(message, "That is not a valid book to return.");
    }

    @Test
    public void should_not_return_book_when_reader_id_is_incorrect() {
        bookService.checkoutItem("B1", "100-0001");
        String message = bookService.returnCheckedItem("B1", "XXX-XXXX");
        assertEquals(message, "That is not a valid book to return.");
    }

    @Test
    public void should_be_able_to_generate_book_column_header() {
        assertEquals(bookService.generateItemColumnHeader(), Book.getColumnHeader());
    }

    @Test
    public void should_be_able_to_generate_book_column_content() {
        Book book = new Book("id", "title", "author", "2015");
        assertEquals(bookService.generateItemColumnContent(book), book.getColumnContent());
    }
}
