package test;

import main.UseCase20TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        assertThrows(IllegalStateException.class, () ->
                UseCase20TrainConsisntMgmt.searchBogie(bogieIds, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        assertDoesNotThrow(() ->
                UseCase20TrainConsisntMgmt.searchBogie(bogieIds, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(
                UseCase20TrainConsisntMgmt.searchBogie(bogieIds, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(
                UseCase20TrainConsisntMgmt.searchBogie(bogieIds, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        assertTrue(
                UseCase20TrainConsisntMgmt.searchBogie(bogieIds, "BG101"));
    }
}