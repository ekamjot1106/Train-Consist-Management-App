package main;

import java.util.List;
import java.util.function.Predicate;

public class UseCase12TrainConsisntMgmt {

    /**
     * Predicate representing safety rules for goods bogies.
     * Cylindrical bogies must carry Petroleum.
     */
    private static final Predicate<GoodsBogie> SAFETY_RULE = bogie ->
            !bogie.getType().equalsIgnoreCase("Cylindrical") ||
                    bogie.getCargo().equalsIgnoreCase("Petroleum");

    /**
     * Validates safety compliance of goods bogies.
     *
     * @param bogies List of GoodsBogie objects
     * @return true if safety compliant, otherwise false
     */
    public static boolean validateSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(SAFETY_RULE);
    }

    /**
     * Displays safety validation result.
     */
    public static void displaySafetyResult(boolean isSafe) {
        if (isSafe) {
            System.out.println("Train Formation is SAFETY COMPLIANT.");
        } else {
            System.out.println("Train Formation is NOT SAFETY COMPLIANT.");
        }
    }
}