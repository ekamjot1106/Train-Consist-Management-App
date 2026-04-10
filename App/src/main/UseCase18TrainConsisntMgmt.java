package main;

/**
 * UC18: Linear Search for Bogie ID (Array-Based Searching)
 */
public class UseCase18TrainConsisntMgmt {

    /**
     * Searches for a bogie ID using Linear Search.
     *
     * @param bogieIds Array of bogie IDs
     * @param searchKey ID to search
     * @return true if found, otherwise false
     */
    public static boolean linearSearch(String[] bogieIds, String searchKey) {
        if (bogieIds == null || searchKey == null) {
            return false;
        }

        for (String id : bogieIds) {
            if (searchKey.equals(id)) { // Safe comparison
                return true; // Early termination
            }
        }
        return false;
    }

    /**
     * Displays the search result.
     */
    public static void displaySearchResult(boolean found, String searchKey) {
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }
    }
}