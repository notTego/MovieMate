package misc;

//import java.util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class User {
    private Credentials credentials;

    public final Credentials getCredentials() {
            return credentials;
    }

    public final void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies = new ArrayList<>();
    private ArrayList<Movie> watchedMovies = new ArrayList<>();
    private ArrayList<Movie> likedMovies = new ArrayList<>();
    private ArrayList<Movie> ratedMovies = new ArrayList<>();

    private ArrayList<String> subscribedGenres = new ArrayList<>();
    /***/
    public ArrayList<String> getSubscribedGenres() {
        return subscribedGenres;
    }
    /***/
    public void setSubscribedGenres(final ArrayList<String> subscribedGenres) {
        this.subscribedGenres = subscribedGenres;
    }

    private int givenScore;

    private Queue<Notification> notifications = new LinkedList<>();
    /***/
    public Queue<Notification> getNotifications() {
        return notifications;
    }
    /***/
    public void setNotifications(final Queue<Notification> notifications) {
        this.notifications = notifications;
    }
    /***/
    public int getGivenScore() {
        return givenScore;
    }
    /***/
    public void setGivenScore(final int givenScore) {
        this.givenScore = givenScore;
    }
    /***/
    public final int getTokensCount() {
        return tokensCount;
    }
    /***/
    public final void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }
    /***/
    public final int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    /***/
    public final void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    /***/
    public final ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }
    /***/
    public final void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    /***/
    public final ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }
    /***/
    public final void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    /***/
    public final ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }
    /***/
    public final void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
    /***/
    public final ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }
    /***/
    public final void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
