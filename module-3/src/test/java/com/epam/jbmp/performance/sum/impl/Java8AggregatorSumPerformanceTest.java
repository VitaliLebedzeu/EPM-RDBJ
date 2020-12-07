package com.epam.jbmp.performance.sum.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.performance.sum.JavaAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorSumPerformanceTest extends JavaAggregatorSumPerformanceTest {

    public Java8AggregatorSumPerformanceTest() {
        super(new Java8Aggregator());
        System.out.print("Java 8 Aggregator Sum Performance Test (ms): ");
    }
}

