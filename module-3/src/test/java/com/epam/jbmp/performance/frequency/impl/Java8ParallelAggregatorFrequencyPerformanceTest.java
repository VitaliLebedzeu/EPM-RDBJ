package com.epam.jbmp.performance.frequency.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.performance.frequency.JavaAggregatorFrequencyPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorFrequencyPerformanceTest extends JavaAggregatorFrequencyPerformanceTest {

    public Java8ParallelAggregatorFrequencyPerformanceTest() {
        super(new Java8ParallelAggregator());
        System.out.print("Java 8 Parallel Aggregator Frequency Performance Test (ms): ");
    }
}
