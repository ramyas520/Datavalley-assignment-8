import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRatings {
    public static void main(String[] args) {
        // Sample movie ratings
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "PG", 7.0));
        movies.add(new Movie("Movie2", "PG-13", 8.5));
        movies.add(new Movie("Movie3", "R", 6.6));
        movies.add(new Movie("Movie4", "PG", 7.3));
        movies.add(new Movie("Movie5", "PG-13", 8.8));

        
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> totalRatingMap = new HashMap<>();

        // Initialize maps with default values
        for (Movie movie : movies) {
            countMap.put(movie.getRating(), 0);
            totalRatingMap.put(movie.getRating(), 0.0);
        }

        // Calculate counts and total ratings for each category
        for (Movie movie : movies) {
            countMap.put(movie.getRating(), countMap.get(movie.getRating()) + 1);
            totalRatingMap.put(movie.getRating(), totalRatingMap.get(movie.getRating()) + movie.getRatingValue());
        }

        // Print results
        System.out.println("Movie Ratings Summary:");
        for (String rating : countMap.keySet()) {
            int count = countMap.get(rating);
            double totalRating = totalRatingMap.get(rating);
            double averageRating = count > 0 ? totalRating / count : 0.0;
            System.out.println("Rating: " + rating + ", Movies: " + count + ", Average Rating: " + averageRating);
        }
    }
}

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}
