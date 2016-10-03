package biblioteca.library;

import biblioteca.enumeration.Role;
import biblioteca.model.Book;
import biblioteca.model.Movie;
import biblioteca.model.UserAccount;

import java.util.HashMap;
import java.util.Map;

import static biblioteca.library.LibraryManager.checkOutABook;
import static biblioteca.library.LibraryManager.checkOutAMovie;

/**
 * Created by hlulani on 2016/10/03.
 */
public class Lists {

    public static final HashMap<String, UserAccount> userAccounts = new HashMap<String, UserAccount>();
    public static final Map<String, Book> books = new HashMap<String, Book>();
    public static final Map<String, Movie> movies = new HashMap<String, Movie>();

    public static Map<String, String> checkedBooks = new HashMap<String, String>();
    public static Map<String, String> checkedMovies = new HashMap<String, String>();

    static {
        books.put("B1", new Book("B1", "Java fundamentals ", "Chauke HR", "2016"));
        books.put("B2", new Book("B2", "TDD by Development", "Kent Beck", "2002"));
        books.put("B3", new Book("B3", "Code refactoring C", "Kent Beck", "2002"));

        movies.put("M1", new Movie("M1", "Rambo 1", "2015", "sylvester stallone", 8.5));
        movies.put("M2", new Movie("M2", "Rambo 2", "2012", "sylvester stallone", 9));
        movies.put("M3", new Movie("M3", "Rambo 3", "2015", "sylvester stallone", 9.1));

        userAccounts.put("100-0001", new UserAccount("100-0001", "123456", "Hlulani", "hchauke@thoughtworks.com", "0603524544", Role.CUSTOMER.CUSTOMER));
        userAccounts.put("100-0002", new UserAccount("100-0002", "123456", "Ralson", "hluly222@gmail.com", "0792225045", Role.LIBRARIAN));

        checkOutABook("B3", "100-0001");
        checkOutAMovie("M3", "100-0002");
    }
}
