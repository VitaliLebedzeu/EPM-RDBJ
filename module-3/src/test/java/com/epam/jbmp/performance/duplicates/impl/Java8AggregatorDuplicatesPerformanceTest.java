package com.epam.jbmp.performance.duplicates.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.performance.duplicates.JavaAggregatorDuplicatesPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorDuplicatesPerformanceTest extends JavaAggregatorDuplicatesPerformanceTest {

    public Java8AggregatorDuplicatesPerformanceTest() {
        super(new Java8Aggregator());
        System.out.print("Java 8 Aggregator Duplicates Performance Test (ms): ");
    }
}

