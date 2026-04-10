package test;

import main.UseCase18TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    private final String[] bogieIds = {
            "BG101", "BG205", "BG309", "BG412", "BG550"
    };

    @Test
    void testSearch_BogieFound() {
        assertTrue(
                UseCase18TrainConsisntMgmt.linearSearch(bogieIds, "BG309")
        );
    }

    @Test
    void testSearch_BogieNotFound() {
        assertFalse(
                UseCase18TrainConsisntMgmt.linearSearch(bogieIds, "BG999")
        );
    }

    @Test
    void testSearch_FirstElementMatch() {
        assertTrue(
                UseCase18TrainConsisntMgmt.linearSearch(bogieIds, "BG101")
        );
    }

    @Test
    void testSearch_LastElementMatch() {
        assertTrue(
                UseCase18TrainConsisntMgmt.linearSearch(bogieIds, "BG550")
        );
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] single = {"BG101"};
        assertTrue(
                UseCase18TrainConsisntMgmt.linearSearch(single, "BG101")
        );
    }
}