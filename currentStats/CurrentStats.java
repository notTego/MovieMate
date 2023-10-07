package currentStats;

import actions.Action;
import misc.Movie;
import misc.Page;
import misc.User;

import java.util.ArrayList;

public class CurrentStats {
    private User currentUser = null;
    private Page currentPage;

    private Page previousPage;
    /***/
    public Page getPreviousPage() {
        return previousPage;
    }

    /***/
    public void setPreviousPage(final Page previousPage) {
        this.previousPage = previousPage;
    }

    private ArrayList<Movie> currentMoviesList;

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Action> actions = new ArrayList<>();


    public final User getCurrentUser() {
        return currentUser;
    }

    public final void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public final Page getCurrentPage() {
        return currentPage;
    }

    public final void setCurrentPage(final Page currentPage) {
        this.currentPage = currentPage;
    }

    public final ArrayList<User> getUsers() {
        return users;
    }

    public final void setUsers(final ArrayList<User> users) {
        this.users = users;
    }

    public final ArrayList<Movie> getMovies() {
        return movies;
    }

    public final void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public final ArrayList<Action> getActions() {
        return actions;
    }

    public final void setActions(final ArrayList<Action> actions) {
        this.actions = actions;
    }

    public final ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public final void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }
}
