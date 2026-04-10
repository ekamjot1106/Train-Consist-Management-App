package test;

import main.Bogie;
import main.UseCase13TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    private List<Bogie> createSampleBogies() {
        return UseCase13TrainConsisntMgmt.generateBogies(100);
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result =
                UseCase13TrainConsisntMgmt.filterUsingLoop(createSampleBogies(), 60);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result =
                UseCase13TrainConsisntMgmt.filterUsingStream(createSampleBogies(), 60);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> loopResult =
                UseCase13TrainConsisntMgmt.filterUsingLoop(bogies, 60);

        List<Bogie> streamResult =
                UseCase13TrainConsisntMgmt.filterUsingStream(bogies, 60);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createSampleBogies();

        long loopTime =
                UseCase13TrainConsisntMgmt.measureLoopExecutionTime(bogies, 60);

        long streamTime =
                UseCase13TrainConsisntMgmt.measureStreamExecutionTime(bogies, 60);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies =
                UseCase13TrainConsisntMgmt.generateBogies(10000);

        List<Bogie> result =
                UseCase13TrainConsisntMgmt.filterUsingStream(bogies, 60);

        assertNotNull(result);
    }
}