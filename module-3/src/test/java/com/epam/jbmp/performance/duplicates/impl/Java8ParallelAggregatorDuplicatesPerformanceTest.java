package com.epam.jbmp.performance.duplicates.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.performance.duplicates.JavaAggregatorDuplicatesPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorDuplicatesPerformanceTest extends JavaAggregatorDuplicatesPerformanceTest {

    public Java8ParallelAggregatorDuplicatesPerformanceTest() {
        super(new Java8ParallelAggregator());
        System.out.print("Java 8 Parallel Aggregator Duplicates Performance Test (ms): ");
    }

}
