package biblioteca.service;

import biblioteca.library.LibraryManager;
import biblioteca.model.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MovieService extends ItemService<Movie> {

    private final String SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE = "Thank you! Enjoy the movie!";
    private final String UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE = "That movie is not available.";
    private final String SUCCESSFUL_RETURN_MOVIE_MESSAGE = "Thank you for returning the movie.";
    private final String UNSUCCESSFUL_RETURN_MOVIE_MESSAGE = "That is not a valid movie to return.";

    @Override
    protected Map<String, Movie> getItemsFromRepository() {
        return LibraryManager.listMovies();
    }

    @Override
    protected Map<String, String> getCheckedItemsFromRepository() {
        return LibraryManager.getCheckedMovies();
    }

    @Override
    protected void sortItemList(List<Movie> itemList) {
        Collections.sort(itemList, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                return movie1.getId().compareTo(movie2.getId());
            }
        });
    }

    @Override
    protected String saveCheckoutItemToRepository(String itemId, String readerId) {
        LibraryManager.saveCheckoutMovie(itemId, readerId);
        return SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE;
    }

    @Override
    protected String returnCheckedItemToRepository(String itemId) {
        LibraryManager.returnCheckedMovie(itemId);
        return SUCCESSFUL_RETURN_MOVIE_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulCheckoutMessage() {
        return UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulReturnMessage() {
        return UNSUCCESSFUL_RETURN_MOVIE_MESSAGE;
    }

    @Override
    public String generateItemColumnHeader() {
        return Movie.getColumnHeader();
    }

    @Override
    public String generateItemColumnContent(Movie item) {
        return item.getColumnContent();
    }

    @Override
    protected String getItemDescription(Movie item) {
        return "Movie: " + item.getName();
    }
}
