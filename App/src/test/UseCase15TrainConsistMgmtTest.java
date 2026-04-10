package test;

import main.GoodsBogie;
import main.UseCase15TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        UseCase15TrainConsisntMgmt.assignCargo(bogie, "Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        UseCase15TrainConsisntMgmt.assignCargo(bogie, "Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        UseCase15TrainConsisntMgmt.assignCargo(bogie, "Petroleum");

        assertNotEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        UseCase15TrainConsisntMgmt.assignCargo(bogie1, "Petroleum");
        UseCase15TrainConsisntMgmt.assignCargo(bogie2, "Petroleum");

        assertEquals("Petroleum", bogie2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Ensures no crash and finally block executes
        assertDoesNotThrow(() ->
                UseCase15TrainConsisntMgmt.assignCargo(bogie, "Petroleum")
        );
    }
}