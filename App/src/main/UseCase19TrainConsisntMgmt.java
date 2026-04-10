package main;

import java.util.Arrays;

/**
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 */
public class UseCase19TrainConsisntMgmt {

    /**
     * Performs binary search on a sorted array of bogie IDs.
     * If the array is unsorted, it will be sorted first.
     *
     * @param bogieIds Array of bogie IDs
     * @param searchKey Bogie ID to search
     * @return true if found, otherwise false
     */
    public static boolean binarySearch(String[] bogieIds, String searchKey) {
        if (bogieIds == null || searchKey == null || bogieIds.length == 0) {
            return false;
        }

        // Sort the array before performing binary search
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Bogie found
            } else if (comparison > 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Bogie not found
    }

    /**
     * Displays the result of the search.
     */
    public static void displayResult(boolean found, String searchKey) {
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }
    }
}