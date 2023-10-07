package actions;

import misc.Credentials;
import misc.Filters;
import misc.Movie;

public class Action {
    private String type;
    private String page;
    private String movie;
    private String feature;
    private Credentials credentials;
    private String startsWith;
    private Filters filters;
    private String count;
    private int rate;

    private String subscribedGenre;

    private Movie addedMovie;
    /***/
    public Movie getAddedMovie() {
        return addedMovie;
    }
    /***/
    public void setAddedMovie(final Movie addedMovie) {
        this.addedMovie = addedMovie;
    }
    /***/
    public String getSubscribedGenre() {
        return subscribedGenre;
    }
    /***/
    public void setSubscribedGenre(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final String getPage() {
        return page;
    }

    public final void setPage(final String page) {
        this.page = page;
    }

    public final String getMovie() {
        return movie;
    }

    public final void setMovie(final String movie) {
        this.movie = movie;
    }

    public final String getFeature() {
        return feature;
    }

    public final void setFeature(final String feature) {
        this.feature = feature;
    }

    public final Credentials getCredentials() {
        return credentials;
    }

    public final void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    public final String getStartsWith() {
        return startsWith;
    }

    public final void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    public final Filters getFilters() {
        return filters;
    }

    public final void setFilters(final Filters filters) {
        this.filters = filters;
    }

    public final String getCount() {
        return count;
    }

    public final void setCount(final String count) {
        this.count = count;
    }

    public final int getRate() {
        return rate;
    }

    public final void setRate(final int rate) {
        this.rate = rate;
    }
}
