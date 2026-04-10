package main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmt {

    /**
     * Groups bogies by their type using Collectors.groupingBy().
     *
     * @param bogies List of Bogie objects
     * @return Map<String, List<Bogie>> where key is bogie type
     */
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    /**
     * Displays grouped bogies in a structured format.
     */
    public static void displayGroupedBogies(Map<String, List<Bogie>> groupedBogies) {
        System.out.println("\n=== Grouped Bogies by Type ===");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println("\nBogie Type: " + type);
            bogieList.forEach(System.out::println);
        });
    }
}