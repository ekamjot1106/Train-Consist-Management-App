package test;

import main.Bogie;
import main.InvalidCapacityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            Bogie bogie = new Bogie("Sleeper", 72);
            assertEquals(72, bogie.getCapacity());
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(
                InvalidCapacityException.class,
                () -> new Bogie("AC Chair", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(
                InvalidCapacityException.class,
                () -> new Bogie("First Class", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                InvalidCapacityException.class,
                () -> new Bogie("Sleeper", -1)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie bogie = new Bogie("AC Chair", 70);

        assertEquals("AC Chair", bogie.getType());
        assertEquals(70, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            Bogie b1 = new Bogie("Sleeper", 72);
            Bogie b2 = new Bogie("AC Chair", 70);
            Bogie b3 = new Bogie("First Class", 50);

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}