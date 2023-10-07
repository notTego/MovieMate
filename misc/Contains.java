package misc;

import java.util.ArrayList;

public class Contains {
    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> genre = new ArrayList<>();

    public final ArrayList<String> getActors() {
        return actors;
    }

    public final void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public final ArrayList<String> getGenre() {
        return genre;
    }

    public final void setGenre(final ArrayList<String> genre) {
        this.genre = genre;
    }
}
