package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsisntMgmt {

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                result.add(bogie);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // Measure loop execution time
    public static long measureLoopExecutionTime(List<Bogie> bogies, int threshold) {
        long startTime = System.nanoTime();
        filterUsingLoop(bogies, threshold);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Measure stream execution time
    public static long measureStreamExecutionTime(List<Bogie> bogies, int threshold) {
        long startTime = System.nanoTime();
        filterUsingStream(bogies, threshold);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Generate large dataset for benchmarking
    public static List<Bogie> generateBogies(int size) {
        List<Bogie> bogies = new ArrayList<>();
        String[] types = {"Sleeper", "AC Chair", "First Class"};

        for (int i = 0; i < size; i++) {
            bogies.add(new Bogie(types[i % types.length], 40 + (i % 80)));
        }
        return bogies;
    }

    // Display performance comparison
    public static void displayPerformance(List<Bogie> bogies, int threshold) {
        long loopTime = measureLoopExecutionTime(bogies, threshold);
        long streamTime = measureStreamExecutionTime(bogies, threshold);

        System.out.println("Loop Execution Time   : " + loopTime + " ns");
        System.out.println("Stream Execution Time : " + streamTime + " ns");
    }
}