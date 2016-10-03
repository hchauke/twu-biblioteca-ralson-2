package com.twu.biblioteca.library;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.UserAccount;

import java.util.Map;

public class LibraryManager {

    static Lists lists = new Lists();

    public static Map<String, Book> listBooks() {
        return lists.books;
    }

    public static void checkOutABook(String bookId, String readerId) {
        lists.checkedBooks.put(bookId, readerId);
    }

    public static Map<String, String> getCheckedBooks() {
        return lists.checkedBooks;
    }

    public static void returnCheckedBook(String bookId) {
        lists.checkedBooks.remove(bookId);
    }

    public static Map<String, Movie> listMovies() {
        return lists.movies;
    }

    public static void checkOutAMovie(String movieId, String readerId) {
        lists.checkedMovies.put(movieId, readerId);
    }

    public static Map<String, String> getCheckedMovies() {
        return lists.checkedMovies;
    }

    public static void returnCheckedMovie(String movieId) {
        Lists.checkedMovies.remove(movieId);
    }

    public static UserAccount findUserAccount(String userId, String password) {
        UserAccount userAccount = Lists.userAccounts.get(userId);
        return (userAccount == null || !userAccount.checkPassword(password)) ? null : userAccount;
    }

    public static Map<String, UserAccount> getUserAccounts() {
        return lists.userAccounts;
    }
}
