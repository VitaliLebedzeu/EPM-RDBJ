package com.epam.jbmp.performance.duplicates.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.performance.duplicates.JavaAggregatorDuplicatesPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorDuplicatesPerformanceTest extends JavaAggregatorDuplicatesPerformanceTest {

    public Java7ParallelAggregatorDuplicatesPerformanceTest() {
        super(new Java7ParallelAggregator());
        System.out.print("Java 7 Parallel Aggregator Duplicates Performance Test (ms): ");
    }
}
