package com.epam.jbmp.performance.duplicates.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.performance.duplicates.JavaAggregatorDuplicatesPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorDuplicatesPerformanceTest extends JavaAggregatorDuplicatesPerformanceTest {

    public Java7AggregatorDuplicatesPerformanceTest() {
        super(new Java7Aggregator());
        System.out.print("Java 7 Aggregator Duplicates Performance Test (ms): ");
    }
}
