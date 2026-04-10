package test;

import main.Bogie;
import main.UseCase10TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    private List<Bogie> createBogies() {
        return new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 70),
                new Bogie("First Class", 50),
                new Bogie("Sleeper", 80)
        ));
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(createBogies());
        assertEquals(272, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(createBogies());
        assertEquals(272, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(
                new Bogie("Sleeper", 72)
        );
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(bogies);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(new ArrayList<>());
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("Sleeper", 80)
        );
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(bogies);
        assertEquals(140, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 40),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 20)
        );
        int total = UseCase10TrainConsisntMgmt.calculateTotalSeats(bogies);
        assertEquals(120, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = createBogies();
        List<Bogie> copy = new ArrayList<>(original);

        UseCase10TrainConsisntMgmt.calculateTotalSeats(original);

        assertEquals(copy.size(), original.size());
        assertEquals(copy.get(0).getCapacity(), original.get(0).getCapacity());
    }
}