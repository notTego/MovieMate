import actions.Action;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import currentStats.CurrentStats;

import misc.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

public final class DoActions {

    private DoActions() {
    }
    private static int ten = 10;
    /***/
    public static boolean userExists(final Credentials login, final ArrayList<User> userDatabase) {
        for (User user : userDatabase) {
            if (login.getName().equals(user.getCredentials().getName())) {
                if (login.getPassword().equals(user.getCredentials().getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    /***/
    public static User returnUser(final Credentials login, final ArrayList<User> database) {
        for (User user : database) {
            if (login.getName().equals(user.getCredentials().getName())) {
                if (login.getPassword().equals(user.getCredentials().getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }

    /***/
    public static void updateSeeDetails(final CurrentStats currentStats, final Output output,
                                        final Action action, final ArrayNode out,
                                        final ObjectMapper objectMapper,
                                        final Hashtable<String, Page> myDict) {
        if (currentStats.getCurrentPage().getPossiblePages().contains(action.getPage())) {
            output.setError("Error");
            output.setCurrentMoviesList(currentStats.getCurrentMoviesList());
            //output.setCurrentMoviesList(new ArrayList<>());
            output.setCurrentUser(currentStats.getCurrentUser());

            out.add(outputObject(output, objectMapper));
            return;
        }



        Movie movie = null;
        Credentials userCredentials = currentStats.getCurrentUser().getCredentials();

        for (Movie iterator : currentStats.getMovies()) {
            if (iterator.getName().equals(action.getPage())
                    && !iterator.getCountriesBanned().contains(userCredentials.getCountry())) {
                movie = iterator;
                break;
            }
        }

        if (movie != null) {
            currentStats.setCurrentPage(myDict.get("see details"));
            currentStats.setCurrentMoviesList(new ArrayList<>());
            currentStats.getCurrentMoviesList().add(movie);

            if (!action.getMovie().equals(movie.getName())) {
                output.setError("Error");
                output.setCurrentMoviesList(new ArrayList<>());
                output.setCurrentUser(null);

                out.add(outputObject(output, objectMapper));
                return;
            }

            output.setError(null);
            output.setCurrentMoviesList(currentStats.getCurrentMoviesList());
            output.setCurrentUser(currentStats.getCurrentUser());

            out.add(outputObject(output, objectMapper));
            return;
        }

        output.setError("Error");
        output.setCurrentMoviesList(new ArrayList<>());
        output.setCurrentUser(null);

        out.add(outputObject(output, objectMapper));
    }

    /***/
    public static ObjectNode outputObject(final Output output, final ObjectMapper objectMapper) {
        ObjectNode userNode = objectMapper.createObjectNode();
        ObjectNode credentialNode = objectMapper.createObjectNode();


        if (output.getError() != null) {
            userNode = null;
        } else {
            credentialNode.put("name", output.getCurrentUser().getCredentials().getName());
            credentialNode.put("password", output.getCurrentUser().getCredentials().getPassword());
            credentialNode.put("accountType", output.getCurrentUser().getCredentials().getAccountType());
            credentialNode.put("country", output.getCurrentUser().getCredentials().getCountry());
            credentialNode.put("balance", output.getCurrentUser().getCredentials().getBalance());

            ArrayNode notifications = objectMapper.createArrayNode();
            for (Notification notification : output.getCurrentUser().getNotifications()) {
                ObjectNode notificationNode = objectMapper.createObjectNode();
                notificationNode.put("movieName", notification.getMovieName());
                notificationNode.put("message", notification.getMessage());

                notifications.add(notificationNode);
          }

            userNode.set("notifications", notifications);
            userNode.set("credentials", credentialNode);
            userNode.put("tokensCount", output.getCurrentUser().getTokensCount());
            userNode.put("numFreePremiumMovies", output.getCurrentUser().getNumFreePremiumMovies());

            ArrayNode purchasedMovies = objectMapper.createArrayNode();
            for (Movie movie : output.getCurrentUser().getPurchasedMovies()) {
                ObjectNode movieNode = objectMapper.createObjectNode();
                movieNode.put("name", movie.getName());
                movieNode.put("year", movie.getYear());
                movieNode.put("duration", movie.getDuration());

                ArrayNode genres = objectMapper.createArrayNode();
                for (String genre : movie.getGenres()) {
                    genres.add(genre);
                }
                movieNode.set("genres", genres);

                ArrayNode actors = objectMapper.createArrayNode();
                for (String actor : movie.getActors()) {
                    actors.add(actor);
                }
                movieNode.set("actors", actors);

                ArrayNode countriesBanned = objectMapper.createArrayNode();
                for (String country : movie.getCountriesBanned()) {
                    countriesBanned.add(country);
                }
                movieNode.set("countriesBanned", countriesBanned);

                movieNode.put("numLikes", movie.getNumLikes());
                movieNode.put("rating", movie.getRating());
                movieNode.put("numRatings", movie.getNumRatings());
                purchasedMovies.add(movieNode);
            }
            userNode.set("purchasedMovies", purchasedMovies);

            ArrayNode watchedMovies = objectMapper.createArrayNode();
            for (Movie movie : output.getCurrentUser().getWatchedMovies()) {
                ObjectNode movieNode = objectMapper.createObjectNode();
                movieNode.put("name", movie.getName());
                movieNode.put("year", movie.getYear());
                movieNode.put("duration", movie.getDuration());

                ArrayNode genres = objectMapper.createArrayNode();
                for (String genre : movie.getGenres()) {
                    genres.add(genre);
                }
                movieNode.set("genres", genres);

                ArrayNode actors = objectMapper.createArrayNode();
                for (String actor : movie.getActors()) {
                    actors.add(actor);
                }
                movieNode.set("actors", actors);

                ArrayNode countriesBanned = objectMapper.createArrayNode();
                for (String country : movie.getCountriesBanned()) {
                    countriesBanned.add(country);
                }
                movieNode.set("countriesBanned", countriesBanned);

                movieNode.put("numLikes", movie.getNumLikes());
                movieNode.put("rating", movie.getRating());
                movieNode.put("numRatings", movie.getNumRatings());
                watchedMovies.add(movieNode);
            }
            userNode.set("watchedMovies", watchedMovies);

            ArrayNode likedMovies = objectMapper.createArrayNode();
            for (Movie movie : output.getCurrentUser().getLikedMovies()) {
                ObjectNode movieNode = objectMapper.createObjectNode();
                movieNode.put("name", movie.getName());
                movieNode.put("year", movie.getYear());
                movieNode.put("duration", movie.getDuration());

                ArrayNode genres = objectMapper.createArrayNode();
                for (String genre : movie.getGenres()) {
                    genres.add(genre);
                }
                movieNode.set("genres", genres);

                ArrayNode actors = objectMapper.createArrayNode();
                for (String actor : movie.getActors()) {
                    actors.add(actor);
                }
                movieNode.set("actors", actors);

                ArrayNode countriesBanned = objectMapper.createArrayNode();
                for (String country : movie.getCountriesBanned()) {
                    countriesBanned.add(country);
                }
                movieNode.set("countriesBanned", countriesBanned);

                movieNode.put("numLikes", movie.getNumLikes());
                movieNode.put("rating", movie.getRating());
                movieNode.put("numRatings", movie.getNumRatings());

                likedMovies.add(movieNode);
            }
            userNode.set("likedMovies", likedMovies);

            ArrayNode ratedMovies = objectMapper.createArrayNode();
            for (Movie movie : output.getCurrentUser().getRatedMovies()) {
                ObjectNode movieNode = objectMapper.createObjectNode();
                movieNode.put("name", movie.getName());
                movieNode.put("year", movie.getYear());
                movieNode.put("duration", movie.getDuration());

                ArrayNode genres = objectMapper.createArrayNode();
                for (String genre : movie.getGenres()) {
                    genres.add(genre);
                }
                movieNode.set("genres", genres);

                ArrayNode actors = objectMapper.createArrayNode();
                for (String actor : movie.getActors()) {
                    actors.add(actor);
                }
                movieNode.set("actors", actors);

                ArrayNode countriesBanned = objectMapper.createArrayNode();
                for (String country : movie.getCountriesBanned()) {
                    countriesBanned.add(country);
                }
                movieNode.set("countriesBanned", countriesBanned);

                movieNode.put("numLikes", movie.getNumLikes());
                movieNode.put("rating", movie.getRating());
                movieNode.put("numRatings", movie.getNumRatings());

                ratedMovies.add(movieNode);
            }
            userNode.set("ratedMovies", ratedMovies);
        }

        ArrayNode currentMovieList = objectMapper.createArrayNode();
        for (Movie movie : output.getCurrentMoviesList()) {
            ObjectNode movieNode = objectMapper.createObjectNode();
            movieNode.put("name", movie.getName());
            movieNode.put("year", movie.getYear());
            movieNode.put("duration", movie.getDuration());

            ArrayNode genres = objectMapper.createArrayNode();
            for (String genre : movie.getGenres()) {
                genres.add(genre);
            }
            movieNode.set("genres", genres);

            ArrayNode actors = objectMapper.createArrayNode();
            for (String actor : movie.getActors()) {
                actors.add(actor);
            }
            movieNode.set("actors", actors);

            ArrayNode countriesBanned = objectMapper.createArrayNode();
            for (String country : movie.getCountriesBanned()) {
                countriesBanned.add(country);
            }
            movieNode.set("countriesBanned", countriesBanned);

            movieNode.put("numLikes", movie.getNumLikes());
            movieNode.put("rating", movie.getRating());
            movieNode.put("numRatings", movie.getNumRatings());

            currentMovieList.add(movieNode);
        }



        ObjectNode outputNode = objectMapper.createObjectNode();
        outputNode.put("error", output.getError());
        outputNode.set("currentMoviesList", currentMovieList);
        outputNode.set("currentUser", userNode);

        return outputNode;
    }
    /***/
    public static boolean MovieIsInList(final Movie needle, final ArrayList<Movie> haystack) {
        for (Movie movie : haystack) {
            if (movie.getName().equals(needle.getName())) {
                return true;
            }
        }
        return false;
    }

    /***/
    public static boolean MovieNameInList(final String needle, final ArrayList<Movie> haystack) {
        for (Movie movie : haystack) {
            if (movie.getName().equals(needle)) {
                return true;
            }
        }
        return false;
    }
    /***/
    public static Movie findMovie(final String needle, final ArrayList<Movie> haystack) {
        for (Movie movie : haystack) {
            if (movie.getName().equals(needle)) {
                return movie;
            }
        }
        return null;
    }

    /***/
    public static void runActions(final CurrentStats currentStats, final Hashtable<String,
                                  Page> myDict,
                                  final ObjectMapper objectMapper, final ArrayNode out) {
        //System.out.print("incepe de aici: \n");
        Output output = new Output(null, new ArrayList<>(), null);
        currentStats.setCurrentMoviesList(new ArrayList<>());



        for (Action action : currentStats.getActions()) {
            int actionHappened = 0;
            ArrayList<Movie> backup = new ArrayList<>();

            if (action.getType().equals("change page")) {

                /*CHANGE PAGE - exception*/
                if (action.getPage().equals("see details")) {

                    for (int i = 0; i < currentStats.getCurrentMoviesList().
                            size(); i++) {
                        if (!currentStats.getCurrentMoviesList().
                                get(i).getName().equals(action.getMovie())) {
                            currentStats.getCurrentMoviesList().remove(i);
                            i--;
                        }
                    }

                    if (currentStats.getCurrentMoviesList().isEmpty()) {


                        backup.addAll(currentStats.getCurrentMoviesList());

                        output.setError("Error");
                        output.setCurrentMoviesList(new ArrayList<>());
                        output.setCurrentUser(null);

                        out.add(outputObject(output, objectMapper));


                        currentStats.setCurrentMoviesList(new ArrayList<>());
                        for (Movie movie : currentStats.getMovies()) {
                            int ok = 1;
                            for (String country : movie.getCountriesBanned()) {
                                if (country.equals(currentStats.
                                        getCurrentUser().getCredentials().
                                        getCountry())) {
                                    ok = 0;
                                    break;
                                }
                            }
                            if (ok == 1) {
                                currentStats.getCurrentMoviesList().add(movie);
                            }

                        }
                        continue;
                    }

                    if (!MovieNameInList(action.getMovie(), currentStats.getCurrentMoviesList())) {
                        currentStats.setCurrentMoviesList(new ArrayList<>());
                        for (Movie movie : currentStats.getMovies()) {
                            int ok = 1;
                            for (String country : movie.getCountriesBanned()) {
                                if (country.equals(currentStats.
                                        getCurrentUser().getCredentials().
                                        getCountry())) {
                                    ok = 0;
                                    break;
                                }
                            }
                            if (ok == 1) {
                                currentStats.getCurrentMoviesList().add(movie);
                            }

                        }


                        output.setError("Error");
                        output.setCurrentMoviesList(new ArrayList<>());
                        output.setCurrentUser(null);

                        out.add(outputObject(output, objectMapper));
                        continue;
                    }
                    int ok = 0;
                    if (currentStats.getCurrentUser() != null) {
                        for (Movie movie : currentStats.getCurrentMoviesList()) {

                            if (action.getMovie().equals(movie.getName())) {

                                currentStats.setCurrentPage(myDict.get("see details"));
                                output.setError(null);
                                output.setCurrentMoviesList(currentStats.getCurrentMoviesList());
                                output.setCurrentUser(currentStats.getCurrentUser());

                                out.add(outputObject(output, objectMapper));
                                ok = 1;
                                break;
                            }

                        }
                    } else {
                        output.setError("Error");
                        output.setCurrentMoviesList(new ArrayList<>());
                        output.setCurrentUser(null);

                        out.add(outputObject(output, objectMapper));
                    }

                    continue;
                }


                /*CHANGE PAGE*/
                if (currentStats.getCurrentPage().getPossiblePages().contains(action.getPage())) {
                    currentStats.setPreviousPage(currentStats.getCurrentPage());
                    currentStats.setCurrentPage(myDict.get(action.getPage()));
                    actionHappened = 1;
                } else {
                    //exception

                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);



                    out.add(outputObject(output, objectMapper));
                    actionHappened = 0;


                }

//              Do this when entering a new page
                if (currentStats.getCurrentPage().getName().equals("logout")) {

                    currentStats.setCurrentMoviesList(new ArrayList<>());
                    currentStats.setCurrentPage(myDict.get("unauth"));
                    currentStats.setCurrentUser(null);
                }

                if (currentStats.getCurrentPage().getName().
                        equals("movies") && actionHappened == 1) {
                    if (currentStats.getCurrentUser() != null) {
                        currentStats.setCurrentMoviesList(new ArrayList<>());
                        for (Movie movie : currentStats.getMovies()) {
                            int ok = 1;
                            for (String country : movie.getCountriesBanned()) {
                                if (country.equals(currentStats.
                                        getCurrentUser().getCredentials().
                                        getCountry())) {
                                    ok = 0;
                                    break;
                                }
                            }
                            if (ok == 1)
                                currentStats.getCurrentMoviesList().add(movie);

                        }


                        output.setError(null);
                        output.setCurrentMoviesList(currentStats.getCurrentMoviesList());
                        output.setCurrentUser(currentStats.getCurrentUser());

                        out.add(outputObject(output, objectMapper));
                    } else {
                        output.setError("Error");
                        output.setCurrentMoviesList(new ArrayList<>());
                        output.setCurrentUser(null);

                        out.add(outputObject(output, objectMapper));
                    }

                }

            } else if (action.getType().equals("on page")){

                if (currentStats.getCurrentPage().getPermitedActions().
                        contains(action.getFeature())) {
                    //System.out.println("Permits " + action.getFeature());
                    RunFeatures(action, currentStats, output, myDict, out,
                            objectMapper, backup);

                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                    actionHappened = 0;



                }
            } else if (action.getType().equals("back")) {
                //System.out.println(currentStats.getCurrentPage().getName());
                if (!currentStats.getCurrentPage().getName().equals("auth")) {
                    currentStats.setCurrentPage(currentStats.getPreviousPage());
                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                }

            } else if (action.getType().equals("back")) {

                if (currentStats.getCurrentPage().getPermitedActions().
                        contains(action.getFeature())) {
                    //System.out.println("Permits " + action.getFeature());
                    runDbFeatures(action, currentStats, output, myDict, out,
                            objectMapper, backup);

                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                    actionHappened = 0;



                }
            }
        }

    }
    static int maxRating = 5;
    /***/
    public static void RunFeatures(final Action action, final CurrentStats currentStats,
                                   final Output output, final Hashtable<String,
                                   Page> my_dict,
                                   final ArrayNode out, final ObjectMapper objectMapper,
                                   final ArrayList<Movie> backup) {


        switch (action.getFeature()) {
            case "login":

                Credentials needle = new Credentials();
                needle.setName(action.getCredentials().getName());
                needle.setPassword(action.getCredentials().getPassword());

                if (userExists(needle, currentStats.getUsers())) {
                    User loggedin = returnUser(needle, currentStats.getUsers());
                    currentStats.setCurrentUser(loggedin);
                    currentStats.setCurrentPage(my_dict.get("auth"));

                    output.setError(null);
                    output.setCurrentUser(currentStats.getCurrentUser());
                    output.setCurrentMoviesList(currentStats.
                            getCurrentMoviesList());

                    out.add(outputObject(output, objectMapper));

                } else if (!userExists(needle, currentStats.getUsers())){
                    currentStats.setCurrentPage(my_dict.get("unauth"));

                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);



                    out.add(outputObject(output, objectMapper));

                }

                break;
            case "register":

                Credentials regUser = new Credentials();
                regUser.setName(action.getCredentials().getName());
                regUser.setPassword(action.getCredentials().getPassword());
                regUser.setAccountType(action.getCredentials().getAccountType());
                regUser.setCountry(action.getCredentials().getCountry());
                regUser.setBalance(action.getCredentials().getBalance());

                if (userExists(regUser, currentStats.getUsers())) {
                    currentStats.setCurrentPage(my_dict.get("unauth"));

                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);


                    out.add(outputObject(output, objectMapper));
                    break;
                }

                User current = new User();
                current.setCredentials(regUser);

                currentStats.setCurrentUser(current);
                currentStats.getCurrentUser().setTokensCount(0);
                currentStats.getCurrentUser().setNumFreePremiumMovies(15);

                currentStats.getUsers().add(current);
                currentStats.setCurrentPage(my_dict.get("auth"));

                output.setError(null);
                output.setCurrentUser(currentStats.getCurrentUser());
                output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                out.add(outputObject(output, objectMapper));
                break;

            case "search":
                for (int i = 0; i < currentStats.getCurrentMoviesList().size(); i++) {
                    if (!currentStats.getCurrentMoviesList().get(i).getName().
                            startsWith(action.getStartsWith())) {
                        currentStats.getCurrentMoviesList().remove(i);
                        i--;
                    }
                }

                output.setError(null);
                output.setCurrentUser(currentStats.getCurrentUser());
                output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                out.add(outputObject(output, objectMapper));

                break;

            case "filter":
                currentStats.setCurrentMoviesList(new ArrayList<>());
                for (Movie movie : currentStats.getMovies()) {
                    int ok = 1;
                    for (String country : movie.getCountriesBanned()) {
                        if (country.equals(currentStats.getCurrentUser().
                                getCredentials().getCountry())) {
                            ok = 0;
                            break;
                        }
                    }
                    if (ok == 1)
                        currentStats.getCurrentMoviesList().add(movie);

                }

                if (action.getFilters().getContains() != null) {

                    for(int i = 0; i < currentStats.
                            getCurrentMoviesList().size(); i++) {

                        if (!action.getFilters().getContains().
                                getActors().isEmpty()) {
                            boolean ok = false;
                            for (String actor : currentStats.
                                    getCurrentMoviesList().get(i).getActors()) {
                                if (actor.equals(action.
                                        getFilters().getContains().
                                        getActors().get(0))) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {

                                currentStats.getCurrentMoviesList().remove(i);
                                i--;
                            }
                        }
                    }

                    for(int i = 0; i < currentStats.
                            getCurrentMoviesList().size(); i++) {
                        if (!action.getFilters().getContains().
                                getGenre().isEmpty()) {
                            boolean ok = false;
                            for (String genre : currentStats.
                                    getCurrentMoviesList().get(i).getGenres()) {
                                if (genre.equals(action.getFilters().getContains().
                                        getGenre().get(0))) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {
                                currentStats.getCurrentMoviesList().remove(i);
                                i--;
                            }
                        }
                    }
                }

                if (action.getFilters().getSort() != null) {
                    if (action.getFilters().getSort().
                            getRating() != null) {
                        if (action.getFilters().getSort().
                                getRating().equals("decreasing")) {
                            Collections.sort(currentStats.
                                    getCurrentMoviesList(), new Comparator<Movie>() {
                                @Override
                                public int compare(final Movie o1, final Movie o2) {
                                    return Double.compare(o2.
                                            getRating(), o1.getRating());
                                }
                            });
                        }

                        if (action.getFilters().getSort().getRating().
                                equals("increasing")) {
                            Collections.sort(currentStats.
                                    getCurrentMoviesList(), new Comparator<Movie>() {
                                @Override
                                public int compare(final Movie o1, final Movie o2) {
                                    return Double.compare(o1.
                                            getRating(), o2.getRating());
                                }
                            });
                        }
                    }

                    if (action.getFilters().getSort().getDuration() != null) {
                        if (action.getFilters().getSort().getDuration().
                                equals("decreasing")) {
                            Collections.sort(currentStats.
                                    getCurrentMoviesList(), new Comparator<Movie>() {
                                @Override
                                public int compare(final Movie o1, final Movie o2) {
                                    return Integer.compare(o2.getDuration(), o1.getDuration());
                                }
                            });
                        }

                        if (action.getFilters().getSort().getDuration().equals("increasing")) {
                            Collections.sort(currentStats.
                                    getCurrentMoviesList(), new Comparator<Movie>() {
                                @Override
                                public int compare(final Movie o1, final Movie o2) {
                                    return Integer.compare(o1.getDuration(), o2.getDuration());
                                }
                            });
                        }
                    }
                }


                output.setError(null);
                output.setCurrentUser(currentStats.getCurrentUser());
                output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                out.add(outputObject(output, objectMapper));
                break;

            case "buy tokens":
                int tokens = Integer.parseInt(action.getCount());
                currentStats.getCurrentUser().setTokensCount(currentStats.
                        getCurrentUser().getTokensCount() + tokens);
                int balance = Integer.parseInt(currentStats.
                        getCurrentUser().getCredentials().getBalance());
                balance -= tokens;
                currentStats.getCurrentUser().getCredentials().
                        setBalance(Integer.toString(balance));
                break;

            case "buy premium account":
                currentStats.getCurrentUser().setTokensCount(currentStats.
                        getCurrentUser().getTokensCount() - ten);
                currentStats.getCurrentUser().getCredentials().setAccountType("premium");
                break;

            case "purchase":
                if (MovieIsInList(currentStats.getCurrentMoviesList().
                        get(0), currentStats.getCurrentUser().
                        getPurchasedMovies())) {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));

                } else {
                    if (currentStats.getCurrentUser().
                            getNumFreePremiumMovies() > 0 && currentStats.
                            getCurrentUser().getCredentials().getAccountType().
                            equals("premium")) {
                        currentStats.getCurrentUser().getPurchasedMovies().
                                add(currentStats.getCurrentMoviesList().get(0));
                        currentStats.getCurrentUser().
                                setNumFreePremiumMovies(currentStats.
                                        getCurrentUser().
                                        getNumFreePremiumMovies() - 1);
                    } else if (currentStats.getCurrentUser().
                            getTokensCount() > 0 || currentStats.
                            getCurrentUser().getCredentials().
                            getAccountType().equals("standard")) {
                        currentStats.getCurrentUser().getPurchasedMovies().
                                add(currentStats.getCurrentMoviesList().get(0));
                        currentStats.getCurrentUser().
                                setTokensCount(currentStats.
                                        getCurrentUser().getTokensCount() - 2);
                    }

                    output.setError(null);
                    output.setCurrentUser(currentStats.getCurrentUser());
                    output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                    out.add(outputObject(output, objectMapper));
                }

                break;

            case "watch":
                if (MovieIsInList(currentStats.getCurrentMoviesList().
                        get(0), currentStats.getCurrentUser().
                        getPurchasedMovies())) {
                    currentStats.getCurrentUser().getWatchedMovies().
                            add(currentStats.getCurrentMoviesList().get(0));

                    output.setError(null);
                    output.setCurrentUser(currentStats.getCurrentUser());
                    output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                    out.add(outputObject(output, objectMapper));
                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));

                }

                break;

            case "like":
                if (MovieIsInList(currentStats.getCurrentMoviesList().
                        get(0), currentStats.getCurrentUser().
                        getWatchedMovies())) {
                    currentStats.getCurrentUser().getLikedMovies().
                            add(currentStats.getCurrentMoviesList().get(0));
                    currentStats.getCurrentMoviesList().get(0).
                            setNumLikes(currentStats.
                                    getCurrentMoviesList().
                                    get(0).getNumLikes() + 1);

                    output.setError(null);
                    output.setCurrentUser(currentStats.getCurrentUser());
                    output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                    out.add(outputObject(output, objectMapper));
                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));

                }

                break;

            case "rate":
                if (MovieIsInList(currentStats.getCurrentMoviesList().
                        get(0), currentStats.getCurrentUser().
                        getWatchedMovies())) {
                    if (!MovieIsInList(currentStats.getCurrentMoviesList().
                            get(0), currentStats.getCurrentUser().
                            getRatedMovies())) {
                        int rating = action.getRate();


                        if (rating > maxRating) {
                            output.setError("Error");
                            output.setCurrentMoviesList(new ArrayList<>());
                            output.setCurrentUser(null);

                            out.add(outputObject(output, objectMapper));
                        } else {
                            currentStats.getCurrentUser().getRatedMovies().
                                    add(currentStats.getCurrentMoviesList().
                                            get(0));
                            Integer rating1 = rating;
                            currentStats.getCurrentUser().setGivenScore(rating);
                            currentStats.getCurrentMoviesList().get(0).
                                    setNumRatings(currentStats.getCurrentMoviesList().
                                            get(0).getNumRatings() + 1);

                            currentStats.getCurrentMoviesList().get(0).getRatings().
                                    add(rating1);

                            double sum = 0;
                            for (Integer i : currentStats.getCurrentMoviesList().
                                    get(0).getRatings()) {
                                sum += i;
                            }

                            currentStats.getCurrentMoviesList().get(0).
                                    setRating(sum / currentStats.
                                            getCurrentMoviesList().
                                            get(0).getRatings().size());



                            output.setError(null);
                            output.setCurrentUser(currentStats.getCurrentUser());
                            output.setCurrentMoviesList(currentStats.getCurrentMoviesList());

                            out.add(outputObject(output, objectMapper));
                        }
                    } else {
                        int rating = action.getRate();
                        Integer rating1 = rating;

                        // remove a rating equal to the initial score given by the
                        // user, from the scores array
                        for (int i = 0; i < currentStats.getCurrentMoviesList().
                                get(0).getRatings().size(); i++) {
                            if (currentStats.getCurrentMoviesList().get(0).
                                    getRatings().get(i).equals(currentStats.
                                            getCurrentUser().getGivenScore())) {
                                currentStats.getCurrentMoviesList().get(0).
                                        getRatings().remove(i);
                                break;
                            }
                        }

                        // add new score to the score array and recalculate average score
                        currentStats.getCurrentMoviesList().get(0).getRatings().add(rating1);

                        // new score is the last score given by the curent user
                        currentStats.getCurrentUser().setGivenScore(rating);

                        double sum = 0;
                        for (Integer i : currentStats.getCurrentMoviesList().get(0).getRatings()) {
                            sum += i;
                        }

                        currentStats.getCurrentMoviesList().get(0).
                                setRating(sum / currentStats.getCurrentMoviesList().
                                        get(0).getRatings().size());

                        output.setError(null);
                        output.setCurrentUser(currentStats.getCurrentUser());
                        output.setCurrentMoviesList(currentStats.
                                getCurrentMoviesList());

                        out.add(outputObject(output, objectMapper));

                    }
                } else {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));

                }

                break;

            case "subscribe":
                if (!currentStats.getCurrentPage().getName().equals("see details")) {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                } else if (!currentStats.getCurrentMoviesList().get(0).getGenres().
                        contains(action.getSubscribedGenre())) {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                } else if (currentStats.getCurrentUser().getSubscribedGenres().
                        contains(action.getSubscribedGenre())) {
                    output.setError("Error");
                    output.setCurrentMoviesList(new ArrayList<>());
                    output.setCurrentUser(null);

                    out.add(outputObject(output, objectMapper));
                } else {
                    currentStats.getCurrentUser().getSubscribedGenres().
                            add(action.getSubscribedGenre());
                }
                break;

            default:
                output.setError("Error");
                output.setCurrentMoviesList(new ArrayList<>());
                output.setCurrentUser(null);

                out.add(outputObject(output, objectMapper));
                break;
        }

    }
    /***/
    public static boolean interestedInMovie(final User user, final Movie movie) {
        for (String movieGenre : movie.getGenres()) {
            for (String interestedGenre : user.getSubscribedGenres()) {
                if (movieGenre.equals(interestedGenre)) {
                    return true;
                }
            }
        }
        return false;
    }
    /***/
    public static boolean available(final User user, final Movie movie) {
        for (String country : movie.getCountriesBanned()) {
            if (country.equals(user.getCredentials().getCountry())) {
                return false;
            }
        }
        return true;
    }
    /***/
    public static void broadcastNotification(final Movie movie, final CurrentStats currentStats) {
        Notification notification = new Notification();
        notification.setMovieName(movie.getName());
        notification.setMessage("ADD");

        for (User user : currentStats.getUsers()) {
            if (interestedInMovie(user, movie) && available(user, movie)) {
                user.getNotifications().offer(notification);
            }
        }
    }
    /***/
    public static void runDbFeatures(final Action action, final CurrentStats currentStats,
                                     final Output output, final Hashtable<String, Page> myDict,
                                     final ArrayNode out, final ObjectMapper objectMapper,
                                     final ArrayList<Movie> backup) {

        switch (action.getFeature()) {
            case "add":
                currentStats.getMovies().add(action.getAddedMovie());
                broadcastNotification(action.getAddedMovie(), currentStats);
                break;
            default:
                break;
        }
    }
}



