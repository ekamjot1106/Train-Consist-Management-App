package main;

import java.util.List;

public class UseCase10TrainConsisntMgmt {

    /**
     * Calculates the total seating capacity of all bogies
     * using Stream API and reduce().
     *
     * @param bogies List of Bogie objects
     * @return Total seating capacity
     */
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)   // Extract capacity
                .reduce(0, Integer::sum);  // Sum all capacities
    }

    /**
     * Displays the total seating capacity.
     */
    public static void displayTotalSeats(int totalSeats) {
        System.out.println("Total Seating Capacity of the Train: " + totalSeats);
    }
}