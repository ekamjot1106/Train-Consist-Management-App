package test;

import main.Bogie;
import main.UseCase9TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    // Helper method to create sample bogies
    private List<Bogie> createBogies() {
        return new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 70),
                new Bogie("First Class", 50),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 65)
        ));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogiesByType(createBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(createBogies());

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(createBogies());

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 80)
        );

        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(createBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result =
                main.UseCase9TrainConsistMgmt.groupBogiesByType(createBogies());

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = createBogies();
        List<Bogie> copy = new ArrayList<>(original);

        main.UseCase9TrainConsistMgmt.groupBogiesByType(original);

        assertEquals(copy.size(), original.size());
        assertEquals(copy.get(0).getType(), original.get(0).getType());
    }
}