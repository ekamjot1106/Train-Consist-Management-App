package test;

import main.Bogie;
import main.UseCase8TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    // Helper method to create sample bogies
    private List<Bogie> createBogies() {
        return new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 70),
                new Bogie("First Class", 50),
                new Bogie("Sleeper", 80)
        ));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 70);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 70);

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 70);

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 60);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(createBogies(), 40);

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result =
                UseCase8TrainConsisntMgmt.filterBogiesByCapacity(new ArrayList<>(), 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = createBogies();
        List<Bogie> copy = new ArrayList<>(original);

        UseCase8TrainConsisntMgmt.filterBogiesByCapacity(original, 70);

        assertEquals(copy.size(), original.size());
        assertEquals(copy.get(0).getCapacity(), original.get(0).getCapacity());
    }
}