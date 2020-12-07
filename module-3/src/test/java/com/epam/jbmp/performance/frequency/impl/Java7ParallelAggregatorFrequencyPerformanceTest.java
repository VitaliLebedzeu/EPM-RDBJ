package com.epam.jbmp.performance.frequency.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.performance.frequency.JavaAggregatorFrequencyPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorFrequencyPerformanceTest extends JavaAggregatorFrequencyPerformanceTest {

    public Java7ParallelAggregatorFrequencyPerformanceTest() {
        super(new Java7ParallelAggregator());
        System.out.print("Java 7 Parallel Aggregator Frequency Performance Test (ms): ");
    }
}
