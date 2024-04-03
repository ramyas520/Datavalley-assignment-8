import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookReviews {
    public static void main(String[] args) {
        List<Integer> reviews = new ArrayList<>();
        // Add sample book reviews
        reviews.add(4);
        reviews.add(3);
        reviews.add(8);
        reviews.add(5);
        reviews.add(8);
        reviews.add(2);
        reviews.add(6);
        reviews.add(5);
        reviews.add(10);

        // Define rating ranges
        int[][] ratingRanges = {{1, 5}, {6, 10}};

        // Initialize counters for rating ranges
        Map<String, Integer> rangeCounts = new HashMap<>();
        for (int[] range : ratingRanges) {
            int lower = range[0];
            int upper = range[1];
            String rangeKey = lower + "-" + upper;
            rangeCounts.put(rangeKey, 0);
        }

        // Initialize counters for review sentiments
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        // Count books within rating ranges and review sentiments
        for (int rating : reviews) {
            for (int[] range : ratingRanges) {
                int lower = range[0];
                int upper = range[1];
                if (rating >= lower && rating <= upper) {
                    String rangeKey = lower + "-" + upper;
                    rangeCounts.put(rangeKey, rangeCounts.get(rangeKey) + 1);
                    break; // Break the inner loop since we found the range
                }
            }
            // Determine review sentiment
            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4 && rating <= 6) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        // Print results
        System.out.println("Books reviewed within rating ranges:");
        for (int[] range : ratingRanges) {
            int lower = range[0];
            int upper = range[1];
            String rangeKey = lower + "-" + upper;
            int count = rangeCounts.get(rangeKey);
            System.out.println(lower + "-" + upper + " stars: " + count + " books");
        }
        System.out.println("Positive reviews: " + positiveCount + " books");
        System.out.println("Neutral reviews: " + neutralCount + " books");
        System.out.println("Negative reviews: " + negativeCount + " books");
    }
}
