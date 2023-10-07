import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import currentStats.CurrentStats;

import misc.Page;
import misc.User;
import misc.Database;

import static misc.PageSetup.logout;
import static misc.PageSetup.auth;
import static misc.PageSetup.login;
import static misc.PageSetup.movies;
import static misc.PageSetup.register;
import static misc.PageSetup.seeDetails;
import static misc.PageSetup.unauth;
import static misc.PageSetup.upgrades;

public final class Main {
    /***/
    private Main() {
    }

    /***/
    public static void main(final String[] args) throws IOException {
        final int premium = 15;

        ObjectMapper objectMapper = new ObjectMapper();
        CurrentStats currentStats = objectMapper.readValue(new File(args[0]), CurrentStats.class);
        for (User user : currentStats.getUsers()) {
            user.setNumFreePremiumMovies(premium);
        }

        Page unauth = unauth();
        Page login = login();
        Page register = register();
        Page auth = auth();
        Page movies = movies();
        Page seeDetails = seeDetails();
        Page upgrades = upgrades();
        Page logout = logout();

        Hashtable<String, Page> myDict = new Hashtable<String, Page>();
        myDict.put("unauth", unauth);
        myDict.put("login", login);
        myDict.put("register", register);
        myDict.put("auth", auth);
        myDict.put("movies", movies);
        myDict.put("see details", seeDetails);
        myDict.put("upgrades", upgrades);
        myDict.put("logout", logout);

        // database singleton contains page hierarchy and page-name association
        Database database = Database.getInstance(myDict);

        currentStats.setCurrentPage(unauth);

        ArrayNode out = objectMapper.createArrayNode();

        DoActions.runActions(currentStats, database.getMyDict(), objectMapper, out);



        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), out);

        int bruh = 0;
    }

}
