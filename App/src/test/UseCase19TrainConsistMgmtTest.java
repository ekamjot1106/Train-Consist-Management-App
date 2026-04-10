package test;

import main.UseCase19TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmtTest {

    private final String[] sortedBogies = {
            "BG101", "BG205", "BG309", "BG412", "BG550"
    };

    @Test
    void testBinarySearch_BogieFound() {
        assertTrue(UseCase19TrainConsisntMgmt
                .binarySearch(sortedBogies.clone(), "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        assertFalse(UseCase19TrainConsisntMgmt
                .binarySearch(sortedBogies.clone(), "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        assertTrue(UseCase19TrainConsisntMgmt
                .binarySearch(sortedBogies.clone(), "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        assertTrue(UseCase19TrainConsisntMgmt
                .binarySearch(sortedBogies.clone(), "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] single = {"BG101"};
        assertTrue(UseCase19TrainConsisntMgmt
                .binarySearch(single, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] empty = {};
        assertFalse(UseCase19TrainConsisntMgmt
                .binarySearch(empty, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] unsorted = {
                "BG309", "BG101", "BG550", "BG205", "BG412"
        };

        assertTrue(UseCase19TrainConsisntMgmt
                .binarySearch(unsorted, "BG205"));
    }
}