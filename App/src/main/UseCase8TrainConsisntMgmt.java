package main;

import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsisntMgmt {

    // Filters bogies with capacity greater than the threshold
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // Displays bogies
    public static void displayBogies(List<Bogie> bogies) {
        bogies.forEach(System.out::println);
    }
}