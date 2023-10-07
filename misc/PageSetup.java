package misc;

import java.util.ArrayList;

public final class PageSetup {

    /***/
    private PageSetup() {
    }

    /***/
    public static Page unauth() {
        Page unauth = new Page();
        unauth.setName("unauth");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");

        ArrayList<String> pages = new ArrayList<>();
        pages.add("login");
        pages.add("register");
        pages.add("unauth");

        unauth.setPermitedActions(actions);
        unauth.setPossiblePages(pages);

        return unauth;
    }

    /***/
    public static Page login() {
        Page login = new Page();
        login.setName("login");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("login");

        ArrayList<String> pages = new ArrayList<>();
        pages.add("login");

        login.setPermitedActions(actions);
        login.setPossiblePages(pages);

        return login;
    }

    /***/
    public static Page register() {
        Page register = new Page();
        register.setName("register");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("register");

        ArrayList<String> pages = new ArrayList<>();
        pages.add("register");

        register.setPermitedActions(actions);
        register.setPossiblePages(pages);
        return register;
    }

    /***/
    public static Page auth() {

        Page auth = new Page();
        auth.setName("auth");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");


        ArrayList<String> pages = new ArrayList<>();
        pages.add("movies");
        pages.add("upgrades");
        pages.add("logout");
        pages.add("auth");

        auth.setPermitedActions(actions);
        auth.setPossiblePages(pages);

        return auth;
    }

    /***/
    public static Page movies() {

        Page movies = new Page();
        movies.setName("movies");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");
        actions.add("search");
        actions.add("filter");


        ArrayList<String> pages = new ArrayList<>();
        pages.add("auth");
        pages.add("see details");
        pages.add("logout");
        pages.add("movies");

        movies.setPermitedActions(actions);
        movies.setPossiblePages(pages);

        return movies;
    }

    /***/
    public static Page seeDetails() {

        Page seeDetails = new Page();
        seeDetails.setName("see details");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");
        actions.add("purchase");
        actions.add("watch");
        actions.add("like");
        actions.add("rate");


        ArrayList<String> pages = new ArrayList<>();
        pages.add("auth");
        pages.add("movies");
        pages.add("upgrades");
        pages.add("logout");
        pages.add("see details");

        seeDetails.setPermitedActions(actions);
        seeDetails.setPossiblePages(pages);

        return seeDetails;
    }

    /***/
    public static Page upgrades() {

        Page upgrades = new Page();
        upgrades.setName("upgrades");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");
        actions.add("buy tokens");
        actions.add("buy premium account");


        ArrayList<String> pages = new ArrayList<>();
        pages.add("auth");
        pages.add("movies");
        pages.add("logout");
        pages.add("upgrades");

        upgrades.setPermitedActions(actions);
        upgrades.setPossiblePages(pages);

        return upgrades;
    }

    /***/
    public static Page logout() {

        Page logout = new Page();
        logout.setName("logout");

        ArrayList<String> actions = new ArrayList<>();
        actions.add("change page");


        ArrayList<String> pages = new ArrayList<>();

        logout.setPermitedActions(actions);
        logout.setPossiblePages(pages);

        return logout;
    }

}
