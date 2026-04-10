package main;

/**
 * Handles safe cargo assignment using try-catch-finally.
 */
public class UseCase15TrainConsisntMgmt {

    /**
     * Assigns cargo safely to a goods bogie.
     *
     * Rule:
     * Petroleum can only be assigned to Cylindrical bogies.
     */
    public static void assignCargo(GoodsBogie bogie, String cargo) {
        try {
            // Validate safety rule
            if (bogie.getShape().equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Cargo Assignment: Petroleum cannot be assigned to a Rectangular Bogie."
                );
            }

            // Assign cargo if safe
            bogie.setCargo(cargo);
            System.out.println("Cargo '" + cargo + "' assigned to " +
                    bogie.getShape() + " bogie.");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment process completed.\n");
        }
    }
}