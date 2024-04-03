import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRatings {
    public static void main(String[] args) {
        List<Integer> ratings = new ArrayList<>();
        // Add sample ratings
        ratings.add(3);
        ratings.add(7);
        ratings.add(4);
        ratings.add(5);
        ratings.add(9);
        ratings.add(2);
        ratings.add(6);
        ratings.add(1);
        ratings.add(10);

        // Define rating ranges
        int[][] ratingRanges = {{1, 5}, {6, 10}};

        // Initialize counters for each range
        Map<String, Integer> rangeCounts = new HashMap<>();
        Map<String, Integer> rangeSums = new HashMap<>();

        // Initialize range counters
        for (int[] range : ratingRanges) {
            int lower = range[0];
            int upper = range[1];
            String rangeKey = lower + "-" + upper;
            rangeCounts.put(rangeKey, 0);
            rangeSums.put(rangeKey, 0);
        }

        // Count ratings within ranges and calculate sum
        for (int rating : ratings) {
            for (int[] range : ratingRanges) {
                int lower = range[0];
                int upper = range[1];
                if (rating >= lower && rating <= upper) {
                    String rangeKey = lower + "-" + upper;
                    rangeCounts.put(rangeKey, rangeCounts.get(rangeKey) + 1);
                    rangeSums.put(rangeKey, rangeSums.get(rangeKey) + rating);
                    break; // Break the inner loop since we found the range
                }
            }
        }

        // Calculate average ratings for each range and print results
        System.out.println("Range\t\tCount\t\tAverage Rating");
        for (int[] range : ratingRanges) {
            int lower = range[0];
            int upper = range[1];
            String rangeKey = lower + "-" + upper;
            int count = rangeCounts.get(rangeKey);
            int sum = rangeSums.get(rangeKey);
            double average = (double) sum / count;
            System.out.println(lower + "-" + upper + "\t\t" + count + "\t\t" + average);
        }
    }
}
