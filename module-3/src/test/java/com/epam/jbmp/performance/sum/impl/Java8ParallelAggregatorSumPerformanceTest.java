package com.epam.jbmp.performance.sum.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.performance.sum.JavaAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorSumPerformanceTest extends JavaAggregatorSumPerformanceTest {

    public Java8ParallelAggregatorSumPerformanceTest() {
        super(new Java8ParallelAggregator());
        System.out.print("Java 8 Parallel Aggregator Sum Performance Test (ms): ");
    }
}
