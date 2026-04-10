package main;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseCase11TrainConsisntMgmt {

    // Regex patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    // Compile patterns
    private static final Pattern TRAIN_ID_PATTERN =
            Pattern.compile(TRAIN_ID_REGEX);

    private static final Pattern CARGO_CODE_PATTERN =
            Pattern.compile(CARGO_CODE_REGEX);

    /**
     * Validates the Train ID using regex.
     *
     * @param trainId Train ID entered by the user
     * @return true if valid, otherwise false
     */
    public static boolean validateTrainID(String trainId) {
        if (trainId == null || trainId.isEmpty()) {
            return false;
        }
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates the Cargo Code using regex.
     *
     * @param cargoCode Cargo Code entered by the user
     * @return true if valid, otherwise false
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) {
            return false;
        }
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    /**
     * Displays validation results.
     */
    public static void displayValidationResult(String trainId, String cargoCode) {
        System.out.println("\n=== Regex Validation Results ===");

        if (validateTrainID(trainId)) {
            System.out.println("Valid Train ID: " + trainId);
        } else {
            System.out.println("Invalid Train ID: " + trainId);
        }

        if (validateCargoCode(cargoCode)) {
            System.out.println("Valid Cargo Code: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code: " + cargoCode);
        }
    }
}