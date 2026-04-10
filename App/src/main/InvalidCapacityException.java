package main;

/**
 * Custom exception to handle invalid bogie capacity.
 */
public class InvalidCapacityException extends Exception {

    public InvalidCapacityException(String message) {
        super(message);
    }
}