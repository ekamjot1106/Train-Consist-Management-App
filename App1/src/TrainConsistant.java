import java.util.HashSet;
import java.util.Set;

public class TrainConsistApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for Bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add Bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG102"); // Duplicate

        // Display Unique Bogie IDs
        System.out.println("\nUnique Bogie IDs in Train:");
        System.out.println(bogieIds);

        // Program continues...
    }
}