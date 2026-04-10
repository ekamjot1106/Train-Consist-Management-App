package test;

import main.GoodsBogie;
import main.UseCase12TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        assertTrue(UseCase12TrainConsisntMgmt.validateSafetyCompliance(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(UseCase12TrainConsisntMgmt.validateSafetyCompliance(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        assertTrue(UseCase12TrainConsisntMgmt.validateSafetyCompliance(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Cylindrical", "Water")
        );

        assertFalse(UseCase12TrainConsisntMgmt.validateSafetyCompliance(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(UseCase12TrainConsisntMgmt.validateSafetyCompliance(bogies));
    }
}