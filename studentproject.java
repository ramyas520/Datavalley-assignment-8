import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentProjects {
    public static void main(String[] args) {
        // Sample student projects with completion times (in days)
        Map<String, List<Integer>> projects = new HashMap<>();
        projects.put("Alice", List.of(7, 8, 5)); 
        projects.put("Bob", List.of(5, 5, 6)); 
        projects.put("Charlie", List.of(10, 9, 1)); 

        // Constants to define time categories
        final String ON_TIME = "On Time";
        final String LATE = "Late";
        final String EARLY = "Early";

        // Map to store counts and total times for each student
        Map<String, Integer> completionCounts = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        // Initialize maps with default values
        for (String student : projects.keySet()) {
            completionCounts.put(student, 0);
            totalTime.put(student, 0);
        }

        // Calculate counts and total times for each student
        for (String student : projects.keySet()) {
            List<Integer> projectTimes = projects.get(student);
            for (int time : projectTimes) {
                totalTime.put(student, totalTime.get(student) + time); // Add to total time
                if (time <= 7) {
                    completionCounts.put(student, completionCounts.get(student) + 1); // Increment count for on-time projects
                } else {
                    completionCounts.put(student, completionCounts.get(student) - 1); // Decrement count for late projects
                }
            }
        }

        // Calculate average time for each student
        Map<String, Double> averageTime = new HashMap<>();
        for (String student : projects.keySet()) {
            int total = totalTime.get(student);
            int count = projects.get(student).size();
            averageTime.put(student, count > 0 ? (double) total / count : 0.0);
        }

        // Print results
        System.out.println("Project Completion Summary:");
        for (String student : projects.keySet()) {
            System.out.println("Student: " + student);
            System.out.println("Number of projects completed on time: " + completionCounts.get(student));
            System.out.println("Average time to complete projects: " + averageTime.get(student) + " days");
            System.out.println();
        }
    }
}
