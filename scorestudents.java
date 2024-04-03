import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentScores {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        // Add sample scores
        scores.add(84);
        scores.add(89);
        scores.add(92);
        scores.add(78);
        scores.add(60);
        scores.add(72);
        scores.add(96);
        scores.add(82);

        // Calculate average score
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.size();

        // Calculate median score
        Collections.sort(scores);
        int median;
        if (scores.size() % 2 == 0) {
            median = (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2;
        } else {
            median = scores.get(scores.size() / 2);
        }

        // Count students above, at, and below average
        int aboveAverage = 0;
        int atAverage = 0;
        int belowAverage = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAverage++;
            } else if (score == average) {
                atAverage++;
            } else {
                belowAverage++;
            }
        }

        // Print results
        System.out.println("Number of students above average: " + aboveAverage);
        System.out.println("Median score for students above average: " + median);
        System.out.println("Number of students at average: " + atAverage);
        System.out.println("Median score for students at average: " + median);
        System.out.println("Number of students below average: " + belowAverage);
        System.out.println("Median score for students below average: " + median);
    }
}
