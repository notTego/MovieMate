package misc;

import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<String> permitedActions = new ArrayList<>();
    private ArrayList<String> possiblePages = new ArrayList<>();

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final ArrayList<String> getPermitedActions() {
        return permitedActions;
    }

    public final void setPermitedActions(final ArrayList<String> permitedActions) {
        this.permitedActions = permitedActions;
    }

    public final ArrayList<String> getPossiblePages() {
        return possiblePages;
    }

    public final void setPossiblePages(final ArrayList<String> possiblePages) {
        this.possiblePages = possiblePages;
    }
}
