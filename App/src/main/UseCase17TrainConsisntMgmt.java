package main;

import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 */
public class UseCase17TrainConsisntMgmt {

    /**
     * Sorts bogie names alphabetically using Arrays.sort().
     *
     * @param bogieNames Array of bogie type names
     * @return Sorted array of bogie names
     */
    public static String[] sortBogieNames(String[] bogieNames) {
        if (bogieNames == null) {
            return null;
        }

        Arrays.sort(bogieNames); // Built-in optimized sorting
        return bogieNames;
    }

    /**
     * Displays sorted bogie names.
     *
     * @param bogieNames Array of sorted bogie names
     */
    public static void displaySortedBogieNames(String[] bogieNames) {
        System.out.println("Sorted Bogie Names: " +
                Arrays.toString(bogieNames));
    }
}