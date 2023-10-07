import misc.User;
import misc.Movie;

import java.util.ArrayList;

public class Output {
    private String error;
    private ArrayList<Movie> currentMoviesList;
    private User currentUser;

    public final String getError() {
        return error;
    }

    public final void setError(final String error) {
        this.error = error;
    }

    public final ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public final void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public final User getCurrentUser() {
        return currentUser;
    }

    public final void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public Output(final String error, final ArrayList<Movie> currentMoviesList,
                  final User currentUser) {
        this.error = error;
        this.currentMoviesList = currentMoviesList;
        this.currentUser = currentUser;
    }
}


