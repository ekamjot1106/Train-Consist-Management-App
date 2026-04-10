package main;

/**
 * UC20: Exception Handling During Search Operations
 * Demonstrates defensive programming using IllegalStateException.
 */
public class UseCase20TrainConsisntMgmt {

    /**
     * Searches for a bogie ID using Linear Search after validating state.
     *
     * @param bogieIds Array of bogie IDs
     * @param searchKey Bogie ID to search
     * @return true if found, otherwise false
     * @throws IllegalStateException if the bogie list is empty
     */
    public static boolean searchBogie(String[] bogieIds, String searchKey) {

        // Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                    "Search operation failed: No bogies available in the train."
            );
        }

        // Linear search logic
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the search result.
     */
    public static void displayResult(String searchKey, boolean found) {
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }
    }
}