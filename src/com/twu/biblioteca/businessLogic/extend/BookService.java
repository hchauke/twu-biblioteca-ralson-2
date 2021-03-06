package com.twu.biblioteca.businessLogic.extend;

import com.twu.biblioteca.businessLogic.ItemService;
import com.twu.biblioteca.library.LibraryManager;
import com.twu.biblioteca.model.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BookService extends ItemService<Book> {

    private final String SUCCESSFUL_CHECKOUT_BOOK_MESSAGE = "Thank you! Enjoy the book";
    private final String UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE = "That book is not available.";
    private final String SUCCESSFUL_RETURN_BOOK_MESSAGE = "Thank you for returning the book.";
    private final String UNSUCCESSFUL_RETURN_BOOK_MESSAGE = "That is not a valid book to return.";

    @Override
    protected Map<String, String> getCheckedItemsFromLibrary() {
        return LibraryManager.getCheckedBooks();
    }

    @Override
    protected Map<String, Book> getItemsFromLibrary() {
        return LibraryManager.listBooks();
    }

    @Override
    protected void sortItemList(List<Book> itemList) {
        Collections.sort(itemList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getId().compareTo(book2.getId());
            }
        });
    }

    @Override
    protected String saveCheckoutItemToLibrary(String itemId, String readerId) {
        LibraryManager.checkOutABook(itemId, readerId);
        return SUCCESSFUL_CHECKOUT_BOOK_MESSAGE;
    }

    @Override
    protected String returnCheckedItemToLibrary(String itemId) {
        LibraryManager.returnCheckedBook(itemId);
        return SUCCESSFUL_RETURN_BOOK_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulCheckoutMessage() {
        return UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulReturnMessage() {
        return UNSUCCESSFUL_RETURN_BOOK_MESSAGE;
    }

    @Override
    public String generateItemColumnHeader() {
        return Book.getColumnHeader();
    }

    @Override
    public String generateItemColumnContent(Book item) {
        return item.getColumnContent();
    }

    @Override
    protected String getItemDescription(Book item) {
        return "Book: " + item.getTitle();
    }
}
