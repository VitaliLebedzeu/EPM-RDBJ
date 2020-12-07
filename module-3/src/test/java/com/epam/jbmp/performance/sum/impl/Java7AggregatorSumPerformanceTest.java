package com.epam.jbmp.performance.sum.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.performance.sum.JavaAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorSumPerformanceTest extends JavaAggregatorSumPerformanceTest {

    public Java7AggregatorSumPerformanceTest() {
        super(new Java7Aggregator());
        System.out.print("Java 7 Aggregator Sum Performance Test (ms): ");
    }

}
