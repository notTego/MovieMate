package misc;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numLikes = 0;
    private double rating = 0;
    private int numRatings = 0;

    private ArrayList<Integer> ratings = new ArrayList<>();

    /***/
    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    /***/
    public void setRatings(final ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    /***/
    public final int getNumLikes() {
        return numLikes;
    }

    /***/
    public final void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /***/
    public final double getRating() {
        return rating;
    }

    /***/
    public final void setRating(final double rating) {
        this.rating = rating;
    }

    /***/
    public final int getNumRatings() {
        return numRatings;
    }

    /***/
    public final void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /***/
    public final String getName() {
        return name;
    }

    /***/
    public final void setName(final String name) {
        this.name = name;
    }

    /***/
    public final String getYear() {
        return year;
    }

    /***/
    public final void setYear(final String year) {
        this.year = year;
    }

    /***/
    public final int getDuration() {
        return duration;
    }

    /***/
    public final void setDuration(final int duration) {
        this.duration = duration;
    }

    /***/
    public final ArrayList<String> getGenres() {
        return genres;
    }

    /***/
    public final void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /***/
    public final ArrayList<String> getActors() {
        return actors;
    }

    /***/
    public final void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /***/
    public final ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /***/
    public final void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
}
