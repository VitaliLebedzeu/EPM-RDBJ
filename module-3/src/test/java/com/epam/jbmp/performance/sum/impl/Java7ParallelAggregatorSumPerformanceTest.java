package com.epam.jbmp.performance.sum.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.performance.sum.JavaAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorSumPerformanceTest extends JavaAggregatorSumPerformanceTest {

    public Java7ParallelAggregatorSumPerformanceTest() {
        super(new Java7ParallelAggregator());
        System.out.print("Java 7 Parallel Aggregator Sum Performance Test (ms): ");
    }
}
