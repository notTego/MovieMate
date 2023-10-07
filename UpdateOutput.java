//import currentStats.CurrentStats;
//import misc.Movie;
//
//import java.util.ArrayList;

//public class UpdateOutput {
//    /***/
//    public static ArrayList<Movie> UpdateMovieList(final CurrentStats currentStats) {
//        if (currentStats.getCurrentPage().equals("movies")) {
//            for (Movie movie : currentStats.getMovies()) {
//                String country = currentStats.getCurrentUser().getCredentials().getCountry();
//                if (!movie.getCountriesBanned().contains(country)) {
//                    currentStats.getCurrentMoviesList().add(movie);
//                }
//            }
//        }
//        return currentStats.getCurrentMoviesList();
//    }
//}
