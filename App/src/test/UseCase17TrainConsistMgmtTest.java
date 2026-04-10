package test;

import main.UseCase17TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase17TrainConsistMgmtTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        String[] expected = {
                "AC Chair", "First Class", "General", "Luxury", "Sleeper"
        };

        UseCase17TrainConsisntMgmt.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogies = {
                "Luxury", "General", "Sleeper", "AC Chair"
        };

        String[] expected = {
                "AC Chair", "General", "Luxury", "Sleeper"
        };

        UseCase17TrainConsisntMgmt.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogies = {
                "AC Chair", "First Class", "General"
        };

        String[] expected = {
                "AC Chair", "First Class", "General"
        };

        UseCase17TrainConsisntMgmt.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogies = {
                "Sleeper", "AC Chair", "Sleeper", "General"
        };

        String[] expected = {
                "AC Chair", "General", "Sleeper", "Sleeper"
        };

        UseCase17TrainConsisntMgmt.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        String[] expected = {"Sleeper"};

        UseCase17TrainConsisntMgmt.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }
}