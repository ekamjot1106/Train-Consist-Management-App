package main;

/**
 * UC16: Sort Passenger Bogies by Capacity using Bubble Sort.
 */
public class UseCase16TrainConsisntMgmt {

    /**
     * Sorts an array of passenger bogie capacities using Bubble Sort.
     *
     * @param capacities array of bogie capacities
     */
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        boolean swapped;

        // Perform Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap adjacent elements
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: Stop if already sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Displays the sorted capacities.
     *
     * @param capacities sorted array
     */
    public static void displayCapacities(int[] capacities) {
        System.out.print("Sorted Passenger Bogie Capacities: ");
        for (int capacity : capacities) {
            System.out.print(capacity + " ");
        }
        System.out.println();
    }
}