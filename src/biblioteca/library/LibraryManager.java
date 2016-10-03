package biblioteca.library;

import biblioteca.enumeration.Role;
import biblioteca.model.Book;
import biblioteca.model.Movie;
import biblioteca.model.UserAccount;

import java.util.HashMap;
import java.util.Map;

public class LibraryManager {

    private static final HashMap<String, UserAccount> userAccounts = new HashMap<String, UserAccount>();
    private static final Map<String, Book> books = new HashMap<String, Book>();
    private static final Map<String, Movie> movies = new HashMap<String, Movie>();

    private static Map<String, String> checkedBooks = new HashMap<String, String>();
    private static Map<String, String> checkedMovies = new HashMap<String, String>();

    static {
        books.put("B1", new Book("B1", "Java fundamentals ", "Chauke HR", "2016"));
        books.put("B2", new Book("B2", "TDD by Development", "Kent Beck", "2002"));

        movies.put("M1", new Movie("M1", "Rambo 1", "2015", "sylvester stallone", 8.5));
        movies.put("M2", new Movie("M2", "Rambo 2", "2012", "sylvester stallone", 9));
        movies.put("M3", new Movie("M3", "Rambo 3", "2015", "sylvester stallone", 9.1));

        userAccounts.put("100-0001", new UserAccount("100-0001", "123456", "Hlulani", "hchauke@thoughtworks.com", "0603524544", Role.CUSTOMER.CUSTOMER));
        userAccounts.put("100-0002", new UserAccount("100-0002", "123456", "Ralson", "hluly222@gmail.com", "0792225045", Role.LIBRARIAN));

        saveCheckoutBook("B0002", "333-3333");
        saveCheckoutMovie("M0002", "111-1111");
    }

    public static Map<String, Book> listBooks() {
        return books;
    }

    public static void saveCheckoutBook(String bookId, String readerId) {
        checkedBooks.put(bookId, readerId);
    }

    public static Map<String, String> getCheckedBooks() {
        return checkedBooks;
    }

    public static void returnCheckedBook(String bookId) {
        checkedBooks.remove(bookId);
    }

    public static Map<String, Movie> listMovies() {
        return movies;
    }

    public static Map<String, String> getCheckedMovies() {
        return checkedMovies;
    }

    public static void saveCheckoutMovie(String movieId, String readerId) {
        checkedMovies.put(movieId, readerId);
    }

    public static void returnCheckedMovie(String movieId) {
        checkedMovies.remove(movieId);
    }

    public static UserAccount findUserAccount(String userId, String password) {
        UserAccount userAccount = userAccounts.get(userId);
        return (userAccount == null || !userAccount.checkPassword(password)) ? null : userAccount;
    }

    public static Map<String, UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
